package com.bs23.rabbit.messaging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Ahmed Dinar
 * Created 1/3/2021
 */

@Slf4j
@Component
public class RabbitConsumer {

  public void consume(Map<String, String> message) {
    log.info("recievedMessage ------------> " + message);
  }
}
