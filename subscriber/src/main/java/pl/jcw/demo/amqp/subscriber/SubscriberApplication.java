package pl.jcw.demo.amqp.subscriber;

import io.micronaut.runtime.Micronaut;

public class SubscriberApplication {

  public static void main(String[] args) {
    Micronaut.run(SubscriberApplication.class, args);
  }
}
