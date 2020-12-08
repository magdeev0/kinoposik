package tech.itpark.kinoposik;

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

    /*@Bean(name="entityManagerFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        return sessionFactory;
    }*/

    public static void main(String[] args) {
        SpringApplication.run(KinoposikApplication.class, args);
    }

}
