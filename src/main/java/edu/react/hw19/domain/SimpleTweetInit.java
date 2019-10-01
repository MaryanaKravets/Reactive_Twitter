//package edu.react.hw19.domain;
//
//import edu.react.hw19.repo.TweetRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//import reactor.core.publisher.Flux;
//
//@Slf4j
//@Component
//@RequiredArgsConstructor
//public class SimpleTweetInit implements ApplicationRunner {
//
//    private final TweetRepository tweetRepository;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//
//        this.tweetRepository
//                .deleteAll()
//                .thenMany(
//                        Flux.just("rrrr|tttt|Professional Java Development with the Spring Framework",
//                                "eeee|wwww|Cloud Native Java", "qqqq|aaaa|Spring Security 3.1", "yyy|iii|Spring in Action"))
//                .map(t -> t.split("\\|"))
//                .map(tuple -> new Tweet(1,tuple[0], tuple[1], tuple[2]))
//                .flatMap(this.tweetRepository::save)
//                .thenMany(this.tweetRepository.findAll())
//                .subscribe(tweet -> log.info(tweet.toString()));
//    }
//}
