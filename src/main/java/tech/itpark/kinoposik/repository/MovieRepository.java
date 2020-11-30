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

    @Query(value = "select movie_id from movie_genre m where m.genre = ?1", nativeQuery = true)
    List<Long> findMoviesIdByGenre(String incomingGenre);

    @Query(value = "SELECT m FROM Movie m WHERE m.id IN :anyList")
    Iterable<Movie> findAllById(@Param("anyList") Collection<Long> anyList);
}
