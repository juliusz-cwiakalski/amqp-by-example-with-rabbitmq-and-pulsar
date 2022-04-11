package pl.jcw.demo.amqp.subscriber;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import io.micronaut.rabbitmq.connect.ChannelInitializer;
import jakarta.inject.Singleton;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Slf4j
public class AmqpConfig extends ChannelInitializer {

  public static final String QUEUE = "messages-queue";

  @Override
  public void initialize(Channel channel, String name) throws IOException {
    log.info("Configuring channel {}", name);
    channel.queueDeclare(QUEUE, true, false, false, null);
  }
}
