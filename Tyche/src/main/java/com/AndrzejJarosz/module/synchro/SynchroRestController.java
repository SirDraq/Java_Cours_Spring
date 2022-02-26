package com.AndrzejJarosz.module.synchro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SynchroRestController {

    @Autowired
    private RandomJokeLookupService randomJokeLookupService;

    @GetMapping("/api/synchro")
    public SynchroDto synchronize(){

        randomJokeLookupService.getRandomJoke("A", 5000L);
        randomJokeLookupService.getRandomJoke("B", 6000L);
        randomJokeLookupService.getRandomJoke("D", 3000L);

        return new SynchroDto();
    }
}
