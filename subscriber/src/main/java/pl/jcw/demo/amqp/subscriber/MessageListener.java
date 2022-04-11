package pl.jcw.demo.amqp.subscriber;

import io.micronaut.rabbitmq.annotation.Queue;
import io.micronaut.rabbitmq.annotation.RabbitListener;
import lombok.extern.slf4j.Slf4j;

@RabbitListener
@Slf4j
public class MessageListener {

  @Queue(AmqpConfig.QUEUE)
  public void receive(Message message) {
    log.info("Received message: {}", message);
  }
}
