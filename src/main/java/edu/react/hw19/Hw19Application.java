package edu.react.hw19;

import edu.react.hw19.config.TwitterConfig;
import edu.react.hw19.domain.Tweet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableConfigurationProperties(TwitterConfig.class)

public class Hw19Application {

    static void run() {
        Runnable runnable = () -> {
            WebClient client = WebClient.create("http://localhost:8080");
            client
                    .get()
                    .uri("/tweets")
                    .retrieve()
                    .bodyToFlux(Tweet.class)
                    .map(Tweet::toString)
                    .subscribe(System.out::println);
        };
        new Thread(runnable).start();
    }

    public static void main(String[] args) {
        SpringApplication.run(Hw19Application.class, args);
        run();
    }
}
