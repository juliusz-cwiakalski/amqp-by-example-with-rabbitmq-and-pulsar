package pl.jcw.demo.amqp;

import io.micronaut.runtime.Micronaut;

public class RcpServerApplication {

    public static void main(String[] args) {
        Micronaut.run(RcpServerApplication.class, args);
    }
}
