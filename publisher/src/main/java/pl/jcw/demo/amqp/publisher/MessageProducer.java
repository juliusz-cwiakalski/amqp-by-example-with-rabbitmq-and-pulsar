package pl.jcw.demo.amqp.publisher;

import io.micronaut.rabbitmq.annotation.Binding;
import io.micronaut.rabbitmq.annotation.RabbitClient;
import io.micronaut.rabbitmq.annotation.RabbitProperty;

@RabbitClient(AmqpConfig.EXCHANGE)
@RabbitProperty(name = "contentType", value = "application/json")
public interface MessageProducer {

  @Binding(AmqpConfig.ROUTING_KEY)
  void send(Message msg);
}
