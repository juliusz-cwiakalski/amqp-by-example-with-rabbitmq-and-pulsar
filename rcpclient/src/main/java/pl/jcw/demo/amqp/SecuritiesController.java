package pl.jcw.demo.amqp;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Controller
@RequiredArgsConstructor
@Slf4j
class SecuritiesController {
  private final SecuritiesClient securitiesClient;

  @Get("/quotations/")
  Flux<Quotation> getQuotations(@QueryValue String currency) {
    long start = System.currentTimeMillis();

    return Flux.from(securitiesClient.listSecurities(currency))
        .flatMap(Flux::fromIterable)
        .doOnNext(
            security ->
                log.info(
                    "[Since start {}ms] Getting quotation for security {}, ",
                    System.currentTimeMillis() - start,
                    security))
        .flatMap(symbol -> Flux.from(securitiesClient.getQuotation(symbol.getSymbol())))
        .doOnNext(
            quotation ->
                log.info(
                    "[Since start {}ms] Got quotation {}, ",
                    System.currentTimeMillis() - start,
                    quotation));
  }
}
