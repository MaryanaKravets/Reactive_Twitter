package edu.react.hw19.router;

import edu.react.hw19.service.TweetHandler;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class TweetRouter {

    @Bean
    RouterFunction<?> routes(TweetHandler th) {
        return
                route(GET("/tweets"),th::findTweets)
                        .andRoute(GET("/tweets/{date}"),th::findByCreatedAt);
    }
}
