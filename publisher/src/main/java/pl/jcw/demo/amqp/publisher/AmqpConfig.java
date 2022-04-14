package pl.jcw.demo.amqp.publisher;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import io.micronaut.rabbitmq.connect.ChannelInitializer;
import jakarta.inject.Singleton;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Slf4j
public class AmqpConfig extends ChannelInitializer {

  public static final String EXCHANGE = "messages-exchange";

  public static final String QUEUE = "messages-queue";

  public static final String ROUTING_KEY = "jcw.message";

  @Override
  public void initialize(Channel channel, String name) throws IOException {
    log.info("Configuring channel {}", name);
    channel.exchangeDeclare(EXCHANGE, BuiltinExchangeType.DIRECT);
    channel.queueDeclare(QUEUE, true, false, false, null);
    channel.queueBind(QUEUE, EXCHANGE, ROUTING_KEY);
  }
}
