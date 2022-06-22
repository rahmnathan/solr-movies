package com.github.rahmnathan.solr_movies;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MovieIndexer {

    @Scheduled(fixedDelay = 60000)
    public void indexMovies() {

    }
}
