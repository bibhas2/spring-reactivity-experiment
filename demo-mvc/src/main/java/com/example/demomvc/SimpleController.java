package com.example.demomvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.concurrent.CompletionStage;

@RestController
@RequestMapping("/api")
public class SimpleController {
    private final WebTarget target = ClientBuilder.newClient()
            .target("https://jsonplaceholder.typicode.com/");

    @GetMapping("/blog-post")
    public CompletionStage<BlogPost[]> getBlogPosts() {
        return target
            .path("/posts")
            .queryParam("userId", 1)
            .request()
            .rx()
            .get(BlogPost[].class);
    }
}
