package com.pingr.Content.application;

import com.pingr.Content.core.Account;
import com.pingr.Content.core.events.*;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

    @Value(value = "${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public Map<String, Object> consumerConfig() {
        Map<String, Object> props = new HashMap<>();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return props;
    }

    @Bean
    public ConsumerFactory<String, Account> consumerFactory() {
        JsonDeserializer<Account> jsonDeserializer = new JsonDeserializer<>(Account.class);
        jsonDeserializer.addTrustedPackages("*");
        jsonDeserializer.setUseTypeMapperForKey(true);

        return new DefaultKafkaConsumerFactory<>(
                consumerConfig(),
                new StringDeserializer(),
                jsonDeserializer
        );
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Account>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Account> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());

        return factory;
    }


    // =======================


    public ConsumerFactory<String, AccountCreatedEvent> accountCreatedEventConsumerFactory() {
        JsonDeserializer<AccountCreatedEvent> jsonDeserializer = new JsonDeserializer<>(AccountCreatedEvent.class);
        jsonDeserializer.setUseTypeMapperForKey(true);
        jsonDeserializer.addTrustedPackages("*");

        return new DefaultKafkaConsumerFactory<>(
                consumerConfig(),
                new StringDeserializer(),
                jsonDeserializer
        );
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, AccountCreatedEvent>> accountCreatedEventKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, AccountCreatedEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(accountCreatedEventConsumerFactory());

        return factory;
    }


    // ==========================

    public ConsumerFactory<String, AccountDeletedEvent> accountDeletedEventConsumerFactory() {
        JsonDeserializer<AccountDeletedEvent> jsonDeserializer = new JsonDeserializer<>(AccountDeletedEvent.class);
        jsonDeserializer.setUseTypeMapperForKey(true);
        jsonDeserializer.addTrustedPackages("*");

        return new DefaultKafkaConsumerFactory<>(
                consumerConfig(),
                new StringDeserializer(),
                jsonDeserializer
        );
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, AccountDeletedEvent>> accountDeletedEventKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, AccountDeletedEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(accountDeletedEventConsumerFactory());

        return factory;
    }

    //PINGS LISTENER

    public ConsumerFactory<String, PingCreatedEvent> pingCreatedEventConsumerFactory() {
        JsonDeserializer<PingCreatedEvent> jsonDeserializer = new JsonDeserializer<>(PingCreatedEvent.class);
        jsonDeserializer.setUseTypeMapperForKey(true);
        jsonDeserializer.addTrustedPackages("*");

        return new DefaultKafkaConsumerFactory<>(
                consumerConfig(),
                new StringDeserializer(),
                jsonDeserializer
        );
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, PingCreatedEvent>> pingCreatedEventKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, PingCreatedEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(pingCreatedEventConsumerFactory());

        return factory;
    }

    public ConsumerFactory<String, PingDeletedEvent> pingDeletedEventConsumerFactory() {
        JsonDeserializer<PingDeletedEvent> jsonDeserializer = new JsonDeserializer<>(PingDeletedEvent.class);
        jsonDeserializer.setUseTypeMapperForKey(true);
        jsonDeserializer.addTrustedPackages("*");

        return new DefaultKafkaConsumerFactory<>(
                consumerConfig(),
                new StringDeserializer(),
                jsonDeserializer
        );
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, PingDeletedEvent>> pingDeletedEventKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, PingDeletedEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(pingDeletedEventConsumerFactory());

        return factory;
    }

    //FRIENDSHIPS LISTENER

    public ConsumerFactory<String, FriendshipCreatedEvent> friendshipCreatedEventConsumerFactory() {
        JsonDeserializer<FriendshipCreatedEvent> jsonDeserializer = new JsonDeserializer<>(FriendshipCreatedEvent.class);
        jsonDeserializer.setUseTypeMapperForKey(true);
        jsonDeserializer.addTrustedPackages("*");

        return new DefaultKafkaConsumerFactory<>(
                consumerConfig(),
                new StringDeserializer(),
                jsonDeserializer
        );
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, FriendshipCreatedEvent>> friendshipCreatedEventKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, FriendshipCreatedEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(friendshipCreatedEventConsumerFactory());

        return factory;
    }

    public ConsumerFactory<String, FriendshipDeletedEvent> friendshipDeletedEventConsumerFactory() {
        JsonDeserializer<FriendshipDeletedEvent> jsonDeserializer = new JsonDeserializer<>(FriendshipDeletedEvent.class);
        jsonDeserializer.setUseTypeMapperForKey(true);
        jsonDeserializer.addTrustedPackages("*");

        return new DefaultKafkaConsumerFactory<>(
                consumerConfig(),
                new StringDeserializer(),
                jsonDeserializer
        );
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, FriendshipDeletedEvent>> friendshipDeletedEventKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, FriendshipDeletedEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(friendshipDeletedEventConsumerFactory());

        return factory;
    }
}
