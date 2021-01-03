package com.bs23.rabbit.messaging;

import com.bs23.rabbit.model.FundTransfer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ahmed Dinar
 * Created 1/3/2021
 */

@Slf4j
@Service
public class RabbitPublisher {

  @Value("${rabbit.queue}")
  String queueName;

  @Value("${rabbit.exchange}")
  String exchange;

  @Value("${rabbit.routingkey}")
  private String routingkey;

  @Autowired
  private AmqpTemplate rabbitTemplate;

  public void publish(FundTransfer fundTransfer) {
    Map<String, Long> data = new HashMap<>();
    data.put("id", fundTransfer.getId());

    rabbitTemplate.convertAndSend(exchange, routingkey, data);
    log.info("Send msg = " + fundTransfer);
  }
}
