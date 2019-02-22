package com.example.demoreactive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class SimpleController {
    private final WebClient webClient = WebClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();

    @GetMapping("/blog-post")
    public Mono<BlogPost[]> getBlogPosts() {
        return webClient
            .get()
            .uri("https://jsonplaceholder.typicode.com/posts?userId=1")
            .retrieve()
            .bodyToMono(BlogPost[].class);
    }
}
