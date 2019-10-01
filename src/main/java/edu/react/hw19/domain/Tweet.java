package edu.react.hw19.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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
        // @JsonProperty("id_str")
        private long id;

        //  @JsonProperty("created_at")
        private String createdAt;

        //@JsonProperty("text")
        private String text;

//        public Tweet(String name, String text) {
//                this.userName=name;
//                this.text=text;
//        }

        // @JsonProperty("user")
         private String userName;

        public static Tweet fromStatus(Status status) {
                return new Tweet(status.getId(),status.getCreatedAt().toString(), status.getText(),status.getUser().getName());
        }
}


