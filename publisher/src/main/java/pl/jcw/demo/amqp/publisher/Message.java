package pl.jcw.demo.amqp.publisher;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import io.micronaut.core.annotation.Introspected;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = Message.MessageBuilder.class)
@Introspected
public class Message {
  String category;
  String subject;
  String body;

  @JsonPOJOBuilder(withPrefix = "")
  public static class MessageBuilder {}
}
