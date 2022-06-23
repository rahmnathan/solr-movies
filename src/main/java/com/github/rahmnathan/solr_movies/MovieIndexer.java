package com.github.rahmnathan.solr_movies;

import com.github.rahmnathan.solr_movies.sql.Media;
import com.github.rahmnathan.solr_movies.sql.MediaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class MovieIndexer {
    private final MediaRepository mediaRepository;

    @Scheduled(fixedDelay = 60000)
    public void indexMovies() throws Exception {
        log.info("Starting media indexing.");

        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("admin", "wnY1HXhNJ6");
        provider.setCredentials(AuthScope.ANY, credentials);
        HttpClient httpClient = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();

        HttpSolrClient solrClient = new HttpSolrClient.Builder("https://solr.nathanrahm.com/solr")
                .withHttpClient(httpClient)
                .build();

        mediaRepository.streamAll()
                .map(this::mediaToSolrInputDocument)
                .forEach(inputDocument -> {
                    try {
                        log.info("Adding document with title: {}", inputDocument.getField("title").getValue());
                        solrClient.add("movies", inputDocument);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

        solrClient.commit("movies");

        log.info("Media indexing complete.");
    }

    private SolrInputDocument mediaToSolrInputDocument(Media media) {
        SolrInputDocument inputDocument = new SolrInputDocument();
        inputDocument.addField("mediaType", media.getMediaType());
        inputDocument.addField("title", media.getTitle());
        inputDocument.addField("actors", media.getActors());
        inputDocument.addField("imdbRating", media.getImdbRating());
        inputDocument.addField("metaRating", media.getMetaRating());
        inputDocument.addField("releaseYear", media.getReleaseYear());
        inputDocument.addField("genre", media.getGenre());
        inputDocument.addField("plot", media.getPlot());
        return inputDocument;
    }
}
