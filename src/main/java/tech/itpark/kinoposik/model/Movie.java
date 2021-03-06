package tech.itpark.kinoposik.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_generator")
    @SequenceGenerator(name="movie_generator", initialValue = 8, sequenceName = "movie_seq")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "duration")
    private int duration;

    @Column(name = "year")
    private int year;

    @Column(name = "country")
    private String country;

    @Column(name = "stage_director")
    private String stageDirector;

    @ElementCollection
    private List<String> genre;

    @ManyToMany
    private List<Actor> actor;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    public Movie(String name, String imageUrl, int duration, int year, String country, String stageDirector, List<String> genre) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.duration = duration;
        this.year = year;
        this.country = country;
        this.stageDirector = stageDirector;
        this.genre = genre;
    }
}
