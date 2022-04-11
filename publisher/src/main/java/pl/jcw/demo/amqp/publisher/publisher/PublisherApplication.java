package pl.jcw.demo.amqp.publisher.publisher;

import io.micronaut.runtime.Micronaut;

public class PublisherApplication {

  public static void main(String[] args) {
    Micronaut.run(PublisherApplication.class, args);
  }
}
