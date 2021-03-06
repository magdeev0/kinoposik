package tech.itpark.kinoposik;

import org.hibernate.SessionFactory;
import org.hibernate.annotations.SQLInsert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@EntityScan("tech.itpark.kinoposik.model")
//@ComponentScan("tech.itpark.kinoposik.controller")
@EnableJpaRepositories("tech.itpark.kinoposik.repository")

@SpringBootApplication
public class KinoposikApplication {
    @Autowired
    private SessionFactory sessionFactory;

    public static void main(String[] args) {
        SpringApplication.run(KinoposikApplication.class, args);
    }

}
