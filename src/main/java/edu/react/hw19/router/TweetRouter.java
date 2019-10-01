package edu.react.hw19.router;

import edu.react.hw19.domain.Tweet;
import edu.react.hw19.repo.TweetRepository;
import edu.react.hw19.service.TweetHandler;
import edu.react.hw19.service.TweetService;
import edu.react.hw19.service.TwitterService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

import java.util.Collections;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
@RequiredArgsConstructor
public class TweetRouter {

    @Bean
    RouterFunction<?> routes(TweetHandler th) {
        return
                route(GET("/tweets"),th::findTweets)
                        //req -> ok().body(th.findTweets(),Tweet.class))
                        .andRoute(GET("/tweets/{date}"),th::findByCreatedAt);
                              //  req -> ok().body(
                                 // th.findByCreatedAt(req.pathVariable("date")), Tweet.class);
    }
}
