# 5 minutes setup

1. `docker-compose up`
2. `pulsar/set-pulsar-manager-password.sh`
3. Login to pulsar admin: http://localhost:9527/ - login and password are in above script (
   default `admin` / `apachepulsar`)
4. Add pulsar env: `http://pulsar:8080`

# RabbitMQ

Admin panel: [http://localhost:15672/](http://localhost:15672/)

* User: `guest`
* Password: `guest`

## Uploading definitions

https://www.rabbitmq.com/definitions.html

# Pulsar

## Setting apache pulsar admin password

See: https://pulsar.apache.org/docs/en/administration-pulsar-manager/#set-administrator-account-and-password

# Created

`mn create-app --build=gradle --jdk=17 --lang=java --test=junit --features=rabbitmq,lombok pl.jcw.demo.amqp.<service name>`

# Resources

- https://micronaut-projects.github.io/micronaut-rabbitmq/latest/guide/
- https://micronaut-projects.github.io/micronaut-pulsar/latest/guide/
- https://guides.micronaut.io/latest/micronaut-rabbitmq-rpc-gradle-java.html