package pl.jcw.demo.amqp.subscriber;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.Extension;
import org.testcontainers.containers.RabbitMQContainer;

@Slf4j
public class RabbitMQInTestContainer implements Extension {
  private static final RabbitMQContainer rabbitmq =
      new RabbitMQContainer("rabbitmq:3.9.14-management");

  static {
    rabbitmq.start();
    System.setProperty("rabbitmq.uri", rabbitmq.getAmqpUrl());
    log.info("Started test container and set 'rabbitmq.uri' to {}", rabbitmq.getAmqpUrl());
  }
}
