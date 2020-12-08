package tech.itpark.kinoposik.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actor_generator")
    @SequenceGenerator(name="actor_generator", sequenceName = "actor_seq")
    private Long id;

    private String name;

    private int age;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    public Actor(String name) {
        this.name = name;
        this.imageUrl = "https://www.hot-motor.ru/body/clothes/images/no_icon.png";
    }

    public Actor(String name, int age, String imageUrl) {
        this.name = name;
        this.age = age;
        this.imageUrl = imageUrl;
    }
}
