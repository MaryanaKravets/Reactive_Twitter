package edu.react.hw19.repo;

import edu.react.hw19.domain.Tweet;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface TweetRepository extends ReactiveMongoRepository<Tweet, String> {

        Flux<Tweet> findByCreatedAt(String date);
}
