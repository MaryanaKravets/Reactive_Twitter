//package edu.react.hw19.controller;
//
//import edu.react.hw19.domain.Tweet;
//import edu.react.hw19.repo.TweetRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Flux;
//
//@RestController
//@RequiredArgsConstructor
//public class TweetController {
//
//    private final TweetRepository tweetRepository;
//
//    @GetMapping("/tweets")
//    Flux<Tweet> findTweets() {
//        return this.tweetRepository.findAll();
//    }
//
//    @GetMapping("/tweets/{date}")
//    Flux<Tweet> byCreateAt(@PathVariable String date) {
//        return this.tweetRepository.findByCreatedAt(date);
//    }
//}
