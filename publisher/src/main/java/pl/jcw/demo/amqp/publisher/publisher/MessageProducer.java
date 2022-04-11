package pl.jcw.demo.amqp.publisher.publisher;

import io.micronaut.rabbitmq.annotation.Binding;
import io.micronaut.rabbitmq.annotation.RabbitClient;
import io.micronaut.rabbitmq.annotation.RabbitProperty;

@RabbitClient(Config.EXCHANGE)
@RabbitProperty(name = "contentType", value = "application/json")
public interface MessageProducer {

  @Binding(Config.ROUTING_KEY)
  void send(Message msg);
}
