package pl.jcw.demo.amqp;

import io.micronaut.rabbitmq.annotation.Binding;
import io.micronaut.rabbitmq.annotation.RabbitClient;
import io.micronaut.rabbitmq.annotation.RabbitProperty;
import java.util.List;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

@RabbitClient(AmqpConfig.SECURITIES_EXCHANGE)
@RabbitProperty(name = "replyTo", value = "amq.rabbitmq.reply-to")
public interface SecuritiesClient {
  @Binding(AmqpConfig.SYMBOLS_BY_CURRENCY_ROUTING_KEY)
  Publisher<List<Security>> listSecurities(String currency);

  @Binding(AmqpConfig.QUOTATION_ROUTING_KEY)
  Mono<Quotation> getQuotation(String symbol);
}
