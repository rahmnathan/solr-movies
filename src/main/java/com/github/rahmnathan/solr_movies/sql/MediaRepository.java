package com.github.rahmnathan.solr_movies.sql;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface MediaRepository extends CrudRepository<Media, Long> {
    Stream<Media> streamAll();
}
