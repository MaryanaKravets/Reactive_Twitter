package edu.react.hw19.service;

import edu.react.hw19.domain.Tweet;
import edu.react.hw19.repo.TweetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Collections;

@Service
@AllArgsConstructor
public class TweetService {

    private TweetRepository repository;
    private TwitterService twitterService;


    public Flux<Tweet> findByCreatedAt(String data) {
        return repository.findByCreatedAt(data);
    }


    public Flux<Tweet> findTweets() {

        return repository
                .findById("Ukraine")
                .flatMapMany(t->twitterService.findTweets(Collections.singletonList("#spring")));
    }
}
