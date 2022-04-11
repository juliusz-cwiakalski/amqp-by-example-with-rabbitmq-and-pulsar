# https://github.com/apache/pulsar/blob/master/docker/pulsar/Dockerfile
FROM apachepulsar/pulsar:2.9.2
RUN mkdir /pulsar/protocols

# following https://hub.streamnative.io/protocol-handlers/aop/0.1.0/

ADD --chown=10000 https://github.com/streamnative/aop/releases/download/v2.9.2.12/pulsar-protocol-handler-amqp-2.9.2.12.nar /pulsar/protocols

RUN echo "messagingProtocols=amqp" >> /pulsar/conf/standalone.conf
RUN echo "protocolHandlerDirectory=./protocols" >> /pulsar/conf/standalone.conf
