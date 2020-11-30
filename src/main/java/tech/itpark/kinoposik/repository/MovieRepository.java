package tech.itpark.kinoposik.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.itpark.kinoposik.model.Movie;

import java.util.Collection;
import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
    Iterable<Movie> findAllByCountry(String country);

    @Query("select m from Movie m where m.isDeleted = false")
    Iterable<Movie> findAllWithoutDeleted();
    /*@Query(
            value = "select * from movie_genre m where m.genre = :incomingGenre",
            nativeQuery = true)
    List<Long> findAllByGenre(String incomingGenre);

    @Query(value = "SELECT m FROM Movie m WHERE m.genre IN :genres")
    List<Movie> findUserByNameList(@Param("names") Collection<String> genres);*/


    /*@Query("select m from Movie m where m.genre = ?1")
    List<Movie> findAllByGenre(String incomingGenre);*/

}
