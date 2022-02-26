package com.AndrzejJarosz.module.synchro;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class RandomJokeLookupService {

    private final RestTemplate restTemplate;

    public RandomJokeLookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<RandomJokeDto> getRandomJoke(String index, long sleep) {
        try {
            String url = "https://api.chucknorris.io/jokes/random";
            RandomJokeDto results = restTemplate.getForObject(url, RandomJokeDto.class);
            Thread.sleep(sleep);
            System.out.println(String.format("Result %s for %s", index, results));
            return CompletableFuture.completedFuture(results);
        } catch (InterruptedException ex) {
            return CompletableFuture.failedFuture(ex);
        }
    }
}