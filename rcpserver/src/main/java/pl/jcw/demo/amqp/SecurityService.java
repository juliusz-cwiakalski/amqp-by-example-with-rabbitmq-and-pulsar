package pl.jcw.demo.amqp;

import io.micronaut.rabbitmq.annotation.Queue;
import io.micronaut.rabbitmq.annotation.RabbitListener;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;

@RabbitListener
@Slf4j
public class SecurityService {

  @Queue(AmqpConfig.SYMBOLS_QUEUE)
  List<Security> listSecurities(String currency) {
    log.info("listSecurities({})", currency);
    return Stream.of(
            new Security("KGH", "KGHM S.A.", "PLN"),
            new Security("KRU", "Kruk S.A.", "PLN"),
            new Security("NFLX", "Netflix", "USD"),
            new Security("A", "A", "USD"),
            new Security("B", "B", "USD"),
            new Security("C", "C", "USD"),
            new Security("D", "D", "USD"),
            new Security("GOOGL", "Google", "USD"),
            new Security("AMZN", "Amazon", "USD"))
        .filter(s -> s.getCurrency().equals(currency))
        .toList();
  }

  @Queue((AmqpConfig.QUOTATION_QUEUE))
  Optional<Quotation> getQuotation(String symbol) {
    log.info("getQuotation({})", symbol);
    return Stream.of(
            new Quotation("KGH", 168.75, 169),
            new Quotation("KRU", 298.1, 299.3),
            new Quotation("NFLX", 343.89, 344.11),
            new Quotation("A", 1, 2),
            new Quotation("B", 2, 3),
            new Quotation("C", 3, 4),
            new Quotation("D", 4, 5),
            new Quotation("GOOGL", 2567.36, 2568.3),
            new Quotation("AMZN", 3010, 3023.51))
        .filter(quotation -> quotation.getSymbol().equals(symbol))
        .findFirst();
  }
}
