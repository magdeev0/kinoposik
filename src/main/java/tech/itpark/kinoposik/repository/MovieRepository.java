package tech.itpark.kinoposik.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tech.itpark.kinoposik.model.Movie;

import java.util.Collection;
import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
    Iterable<Movie> findAllByCountry(String country);

    @Query("select m from Movie m where m.isDeleted = false")
    Iterable<Movie> findAllWithoutDeleted();

    @Query(value = "select movie_id from movie_genre m where m.genre = :movieGenre", nativeQuery = true)
    List<Long> findMoviesIdByGenre(@Param("movieGenre") String incomingGenre);

    @Query(value = "select m from Movie m where m.id in :anyList")
    Iterable<Movie> findAllById(@Param("anyList") Collection<Long> anyList);

    @Modifying
    @Transactional
    @Query("update Movie m set m.isDeleted = true where m.id = :id")
    void updateMovieById(@Param("id") Long id);
}
