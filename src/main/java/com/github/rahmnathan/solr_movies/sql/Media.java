package com.github.rahmnathan.solr_movies.sql;

import com.github.rahmnathan.solr_movies.MediaType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Media {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="media_sequence_generator")
    @SequenceGenerator(name="media_sequence_generator", sequenceName="MEDIA_SEQUENCE")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private MediaType mediaType;
    private String title;
    private String imdbRating;
    private String metaRating;
    private String releaseYear;
    private String actors;
    @Lob
    private String plot;
    private String genre;
    private Integer number;
    private LocalDateTime created;
    private LocalDateTime updated;

    @Override
    public String toString() {
        return "Media{" +
                "id=" + id +
                ", mediaType=" + mediaType +
                ", title='" + title + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                ", metaRating='" + metaRating + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", actors='" + actors + '\'' +
                ", plot='" + plot + '\'' +
                ", genre='" + genre + '\'' +
                ", number=" + number +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Media media = (Media) o;
        return Objects.equals(id, media.id) && mediaType == media.mediaType && Objects.equals(title, media.title) && Objects.equals(imdbRating, media.imdbRating) && Objects.equals(metaRating, media.metaRating) && Objects.equals(releaseYear, media.releaseYear) && Objects.equals(actors, media.actors) && Objects.equals(plot, media.plot) && Objects.equals(genre, media.genre) && Objects.equals(number, media.number) && Objects.equals(created, media.created) && Objects.equals(updated, media.updated);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, mediaType, title, imdbRating, metaRating, releaseYear, actors, plot, genre, number, created, updated);
        result = 31 * result;
        return result;
    }
}
