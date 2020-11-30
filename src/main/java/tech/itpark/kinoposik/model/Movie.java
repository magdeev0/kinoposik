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
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(name = "image_url")
    private String imageUrl;
    private int duration;
    private int year;
    private String country;
    @Column(name = "stage_director")
    private String stageDirector;
    @ElementCollection
    private List<String> genre;
    @ManyToMany
    private List<Actor> actor;
    private boolean isDeleted;

    public Movie(String name, String imageUrl, int duration, int year, String country, String stageDirector, List<String> genre, List<Actor> actor) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.duration = duration;
        this.year = year;
        this.country = country;
        this.stageDirector = stageDirector;
        this.genre = genre;
        this.actor = actor;
    }
}
