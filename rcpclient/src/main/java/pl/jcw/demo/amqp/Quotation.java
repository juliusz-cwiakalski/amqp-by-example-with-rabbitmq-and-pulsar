package pl.jcw.demo.amqp;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
@Introspected
public class Quotation {
  String symbol;
  double bid;
  double ask;
}
