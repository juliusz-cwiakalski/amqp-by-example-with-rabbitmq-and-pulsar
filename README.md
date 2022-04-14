# Overview

This project demonstrates usage of AMQP with different brokers.

Used tech stack:

- [RabbitMQ](https://www.rabbitmq.com/) - most popular AMQP message broker
- [AMQP on Apache Pulsar](https://github.com/streamnative/aop) - Apache Pulsar is both message
  broker (like RabbitMQ) and event store/streamer (like Kafka)
- [Micronaut RabbitMQ](https://micronaut-projects.github.io/micronaut-rabbitmq/latest/guide/) to
  talk to AMQP brokers.
- Java and Gradle

There are 4 services in this repo grouped in pairs:

- [publisher](./publisher) and [subscriber](./subscriber) is an example of traditional message
  communication.
- [rcpclient](./rcpclient) and [rcpserver](./rcpserver) is an example of loosely coupled synchronous
  communication via [RabbitMQ RCP](https://www.rabbitmq.com/tutorials/tutorial-six-python.html)
  using [Micronaut RabbitMQ RCP](https://guides.micronaut.io/latest/micronaut-rabbitmq-rpc-gradle-java.html) framework

# 5 minutes setup with Docker

**Prerequisites**: working Docker with `docker-compose` available,
see [how to install docker compose](https://docs.docker.com/compose/install/).

All commands should be executed from project root.

1. Execute: `docker-compose up`
2. Setup [Pulsar Manager](https://pulsar.apache.org/docs/en/administration-pulsar-manager/)
    1. Execute: `./pulsar/set-pulsar-manager-password.sh`
    2. Login to pulsar admin: [http://localhost:9527/](http://localhost:9527/) - login and password
       are in [above script](./pulsar/set-pulsar-manager-password.sh) (
       default `admin` / `apachepulsar`) and add pulsar env:
       `http://pulsar:8080` (this address is internal in [docker stack](./docker-compose.yml)).
3. Login to RabbitMQ: [http://localhost:15672/](http://localhost:15672/). Default user/password
   is `guest` / `guest`.

## Ports exposed in [docker stack](./docker-compose.yml)

- `5673` - AMQP connector on Pulsar instance
- `9527` - Pulsar admin web UI
- `5672` - AMQP connector of RabbitMQ
- `15672` - RabbitMQ admin web UI (default user/pass: `guest` / `guest`)

# Notes

## Uploading definitions

RabbitMQ entities deifnitions may be stored in JSON files and uploaded via REST API, CLI etc, see:
[https://www.rabbitmq.com/definitions.html](https://www.rabbitmq.com/definitions.html)

## Setting apache pulsar admin password

Resources related to setting up Apache Pulsar:

- [setting admin password](https://pulsar.apache.org/docs/en/administration-pulsar-manager/#set-administrator-account-and-password)

## Creation of micronaut services

Services were created using [Micronaut CLI](https://micronaut.io/download/) installed
with [SdkMan](https://sdkman.io/) using following command:

```
mn create-app --build=gradle --jdk=17 --lang=java --test=junit \
   --features=rabbitmq,lombok \
   pl.jcw.demo.amqp.<service name>
```

# Useful resources

- https://micronaut-projects.github.io/micronaut-rabbitmq/latest/guide/
- https://micronaut-projects.github.io/micronaut-pulsar/latest/guide/
- https://guides.micronaut.io/latest/micronaut-rabbitmq-rpc-gradle-java.html
