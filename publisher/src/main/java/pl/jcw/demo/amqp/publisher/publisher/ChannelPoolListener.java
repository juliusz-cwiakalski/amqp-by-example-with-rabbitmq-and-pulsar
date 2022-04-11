package pl.jcw.demo.amqp.publisher.publisher;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import io.micronaut.rabbitmq.connect.ChannelInitializer;
import jakarta.inject.Singleton;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Slf4j
public class ChannelPoolListener extends ChannelInitializer {

  @Override
  public void initialize(Channel channel, String name) throws IOException {
    log.info("Configuring channel {}", name);
    channel.exchangeDeclare(Config.EXCHANGE, BuiltinExchangeType.DIRECT);
    channel.queueDeclare(Config.QUEUE, true, false, false, null);
    channel.queueBind(Config.QUEUE, Config.EXCHANGE, Config.ROUTING_KEY);
  }
}
