package pl.jcw.demo.amqp.publisher.publisher;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MessagePublishingController {

  private final MessageProducer messageProducer;

  @Post("/message")
  void postMessage(@Body Message message) {
    log.info("About to publish message {}", message);
    messageProducer.send(message);
  }
}
