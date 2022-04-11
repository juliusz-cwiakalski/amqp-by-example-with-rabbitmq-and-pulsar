package pl.jcw.demo.amqp;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import io.micronaut.rabbitmq.connect.ChannelInitializer;
import jakarta.inject.Singleton;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;

@Singleton
@Slf4j
public class AmqpConfig extends ChannelInitializer {

  public static final String SECURITIES_EXCHANGE = "securities";

  public static final String QUOTATION_QUEUE = "quotation-queue";
  public static final String QUOTATION_ROUTING_KEY = "jcw.securities.quotation";

  public static final String SYMBOLS_QUEUE = "symbols-queue";
  public static final String SYMBOLS_BY_CURRENCY_ROUTING_KEY = "jcw.securities.symbol";

  @Override
  public void initialize(Channel channel, String name) throws IOException {
    log.info("Configuring channel {}", name);
    channel.exchangeDeclare(SECURITIES_EXCHANGE, BuiltinExchangeType.DIRECT);

    channel.queueDeclare(SYMBOLS_QUEUE, true, false, false, null);
    channel.queueBind(SYMBOLS_QUEUE, SECURITIES_EXCHANGE, SYMBOLS_BY_CURRENCY_ROUTING_KEY);

    channel.queueDeclare(QUOTATION_QUEUE, true, false, false, null);
    channel.queueBind(QUOTATION_QUEUE, SECURITIES_EXCHANGE, QUOTATION_ROUTING_KEY);
  }
}
