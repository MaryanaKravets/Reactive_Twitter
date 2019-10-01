package edu.react.hw19.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import twitter4j.conf.ConfigurationBuilder;

@Configuration
public class AppConfig {
    @Bean
    public twitter4j.conf.Configuration configuration(TwitterConfig twitterConfig) {
          return new ConfigurationBuilder()
                .setOAuthConsumerKey(twitterConfig.getConsumerKey())
                .setOAuthConsumerSecret(twitterConfig.getConsumerSecret())
                .setOAuthAccessToken(twitterConfig.getAccessToken())
                .setOAuthAccessTokenSecret(twitterConfig.getAccessTokenSecret())
                .build();
    }
}
