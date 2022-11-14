package com.example.transactional.consumer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;

@Configuration
@Slf4j
class KafkaExceptionHandlingConfiguration {

  @Bean
  public KafkaListenerErrorHandler commonErrorHandler() {
    return (Message<?> message, ListenerExecutionFailedException exception) -> {
      log.error("Failed to consume inbound Kafka message", exception);
      return message;
    };
  }
}
