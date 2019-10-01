package edu.react.hw19.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import twitter4j.Status;

@Document(collection = "tweets")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class Tweet {

        @Id
        private long id;

        private String createdAt;

        private String text;

        private String userName;

        public static Tweet fromStatus(Status status) {
                return new Tweet(status.getId(),status.getCreatedAt().toString(), status.getText(),status.getUser().getName());
        }
}


