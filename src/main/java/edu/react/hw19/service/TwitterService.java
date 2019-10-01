package edu.react.hw19.service;

import edu.react.hw19.domain.Tweet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.Configuration;

import java.util.List;

@Service
@AllArgsConstructor
public class TwitterService {

    private Configuration configuration;

    Flux<Tweet> findByCreatedAt(String data) {

        return Flux.create(sink -> {
            TwitterStream twitterStream = new TwitterStreamFactory(configuration).getInstance();
            twitterStream.onStatus(status -> sink.next(Tweet.fromStatus(status)));
            twitterStream.onException(sink::error);
            twitterStream.filter(data);
            sink.onCancel(twitterStream::shutdown);
        });

    }

    Flux<Tweet> findTweets(List<String> hashtags) {

        return Flux.create(sink -> {
            TwitterStream twitterStream = new TwitterStreamFactory(configuration).getInstance();
            twitterStream.onStatus(status -> sink.next(Tweet.fromStatus(status)));
            twitterStream.onException(sink::error);
            twitterStream.filter(hashtags.toArray(new String[0]));
            sink.onCancel(twitterStream::shutdown);
        });
    }
}
