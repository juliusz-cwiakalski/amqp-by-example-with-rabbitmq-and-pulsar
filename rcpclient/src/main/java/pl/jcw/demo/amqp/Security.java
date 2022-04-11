package pl.jcw.demo.amqp;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@Introspected
@AllArgsConstructor
public class Security {
  String symbol;
  String name;
  String currency;
}
