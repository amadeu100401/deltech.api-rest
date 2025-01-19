package application.common.DTOS;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class MessageWrapper<T> {

    private String id;
    private T body;
    private String timestamp;

    public MessageWrapper() {
    }

    @JsonCreator
    public MessageWrapper(@JsonProperty("id") String id,
                          @JsonProperty("body") T body,
                          @JsonProperty("timestamp") String timestamp) {
        this.id = id;
        this.body = body;
        this.timestamp = timestamp;
    }

    public MessageWrapper(T body) {
        id = UUID.randomUUID().toString();
        this.body = body;
        timestamp = LocalDateTime.now().toString();
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id + "\"," +
                "\"body\":" + body.toString() + "," +
                "\"timestamp\":\"" + timestamp + "\"" +
                "}";
    }
}
