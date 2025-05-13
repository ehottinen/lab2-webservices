package com.example.quoteservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/quotes")
public class QuoteController {

    private static final List<String> QUOTES = List.of(
            "It works on my machine.",
            "Knitting keeps me from stabbing people.",
            "Bury your mistakes under the tomato plants.",
            "Weeks of coding can save you hours of planning.",
            "I don't have bugs. I just develop random features.",
            "Have you tried turning it off and on again?",
            "I came here to drink milk and kick ass. And I’ve just finished my milk.",
            "When in doubt, lick it.",
            "It’s not trash, it’s a cultural deposit."
    );

    private final Random random = new Random();

    @GetMapping("/random")
    public String getRandomQuote() {
        return QUOTES.get(random.nextInt(QUOTES.size()));
    }
}
