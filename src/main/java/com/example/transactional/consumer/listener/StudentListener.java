package com.example.transactional.consumer.listener;

import com.example.transactional.consumer.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StudentListener {

  @KafkaListener(topics = "students", errorHandler = "commonErrorHandler")
  public void student(
      final Acknowledgment acknowledgment,
      @Payload final Student student,
      @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) final String key,
      @Header(KafkaHeaders.RECEIVED_TOPIC) final String topic,
      @Header(KafkaHeaders.RECEIVED_PARTITION_ID) final String partitionId,
      @Header(KafkaHeaders.OFFSET) final String offset) {
    log.info("Topic = {}, partition = {}, offset = {}, key = {}, msg = {}",
        topic, partitionId, offset, key, student);
    acknowledgment.acknowledge();
  }
}
