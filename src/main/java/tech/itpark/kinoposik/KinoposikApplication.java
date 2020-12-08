package tech.itpark.kinoposik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("tech.itpark.kinoposik.model")
@ComponentScan("tech.itpark.kinoposik.controller")
@EnableJpaRepositories("tech.itpark.kinoposik.repository")

@SpringBootApplication
public class KinoposikApplication {

    public static void main(String[] args) {
        SpringApplication.run(KinoposikApplication.class, args);
    }

}
