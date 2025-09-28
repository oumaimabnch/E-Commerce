package com.exemple.orderservice.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.exemple.orderservice.event.DeliveryCreatedEvent;
import com.exemple.orderservice.event.InventoryReservedEvent;
import com.exemple.orderservice.event.OrderPlacedEvent;
import com.exemple.orderservice.event.OutOfStockEvent;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class OrderKafkaConsumerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    private <T> ConsumerFactory<String, T> consumerFactory(Class<T> clazz) {
        JsonDeserializer<T> deserializer = new JsonDeserializer<>(clazz, false);
        deserializer.addTrustedPackages("*");

        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "order-service");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), deserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, InventoryReservedEvent> orderPlacedKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, InventoryReservedEvent> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory(InventoryReservedEvent.class));
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, OutOfStockEvent> outOfStockKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, OutOfStockEvent> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory(OutOfStockEvent.class));
        return factory;
    }

     @Bean
    public ConcurrentKafkaListenerContainerFactory<String, DeliveryCreatedEvent> deliveryCreatedKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, DeliveryCreatedEvent> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory(DeliveryCreatedEvent.class));
        return factory;
    }

   
}
