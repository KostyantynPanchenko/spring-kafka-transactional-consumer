package com.example.transactional.consumer.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.event.ConsumerStoppingEvent;
import org.springframework.kafka.event.ContainerStoppedEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
class KafkaContainerShutdownListener {

  @EventListener(ConsumerStoppingEvent.class)
  public void beforeShutdown() {
    log.error("Stopping consumer container...");
  }

  @EventListener(ContainerStoppedEvent.class)
  public void afterShutdown() {
    log.error("Consumer container stopped.");
  }
}
