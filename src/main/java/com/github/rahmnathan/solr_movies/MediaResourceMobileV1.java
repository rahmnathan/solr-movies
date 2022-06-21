package com.github.rahmnathan.solr_movies;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/")
public class MediaResourceMobileV1 {

    @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getMedia() {
        log.info("Received request.");

        return ResponseEntity.badRequest().build();
    }
}