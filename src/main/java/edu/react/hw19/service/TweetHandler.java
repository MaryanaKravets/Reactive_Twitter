package edu.react.hw19.service;

import edu.react.hw19.domain.Tweet;
import edu.react.hw19.repo.TweetRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Component
@AllArgsConstructor
public class TweetHandler {

    private TweetService service;


    public Mono<ServerResponse> findByCreatedAt(ServerRequest request) {
        return ServerResponse
                .ok()
                .body(service.findByCreatedAt(request.pathVariable("date")), Tweet.class);
    }


    public Mono<ServerResponse> findTweets(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(service.findTweets(),Tweet.class);
    }
}
