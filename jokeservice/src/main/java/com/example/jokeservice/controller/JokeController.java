package com.example.jokeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/jokes")
public class JokeController {

    private static final List<String> JOKES = List.of(
            "Why do Java developers wear glasses? Because they don’t C#.",
            "How many programmers does it take to change a light bulb? None. That’s a hardware problem.",
            "Real programmers count from 0.",
            "There are 10 kinds of people in the world: those who understand binary and those who don’t.",
            "I would love to change the world, but they won’t give me the source code."
    );

    private final Random random = new Random();

    @GetMapping("/random")
    public String getRandomJoke() {
        return JOKES.get(random.nextInt(JOKES.size()));
    }
}

