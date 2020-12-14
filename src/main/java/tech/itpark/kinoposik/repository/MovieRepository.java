package tech.itpark.kinoposik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tech.itpark.kinoposik.model.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>, JpaSpecificationExecutor<Movie> {
    @Query
    Iterable<Movie> findAllByIsDeletedFalseAndCountry(String country);

    @Query
    Iterable<Movie> findAllByIsDeletedFalse();

    @Query(value = "select Movie_id from movie_genre mg where mg.genre = :genre", nativeQuery = true)
    List<Long> findMoviesIdByGenre(@Param("genre") String genre);

    @Modifying
    @Transactional
    @Query("update Movie m set m.isDeleted = true where m.id = :id")
    void deleteMovieById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("update Movie m set m.name = :name, m.imageUrl = :imageUrl, m.year = :year, m.duration = :duration, m.country = :country, m.stageDirector = :stageDirector where m.id = :id")
    void updateMovieById(@Param("id") Long id,
                         @Param("name") String name,
                         @Param("imageUrl") String imageUrl,
                         @Param("year") int year,
                         @Param("duration") int duration,
                         @Param("country") String country,
                         @Param("stageDirector") String stageDirector);

    @Modifying
    @Transactional
    @Query(value = "delete from movie_genre where Movie_id = :id", nativeQuery = true)
    void deleteGenreById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "insert into movie_genre values (:id, :genre)", nativeQuery = true)
    void updateGenreById(@Param("id") Long id,
                         @Param("genre") String genre);

    @Modifying
    @Transactional
    @Query(value = "delete from movies_actors where Movie_id = :id", nativeQuery = true)
    void deleteActorById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "insert into movies_actors values (:movie_id, :actor_id)", nativeQuery = true)
    void updateActorById(@Param("movie_id") Long movie_id,
                         @Param("actor_id") Long actor_id);

    @Query(value = "select Movie_id from movies_actors ma where ma.actor_id = :id limit :limit", nativeQuery = true)
    List<Long> findMoviesIdByActor(@Param("id") Long id,
                                   @Param("limit") int limit);

    @Query
    Iterable<Movie> findAllByIsDeletedFalseOrderByIdDesc();

    @Query
    Iterable<Movie> findAllByIsDeletedFalseOrderByName();

    @Query
    Iterable<Movie> findAllByIsDeletedFalseOrderByNameDesc();

    @Query
    Iterable<Movie> findAllByIsDeletedFalseOrderByYear();

    @Query
    Iterable<Movie> findAllByIsDeletedFalseOrderByYearDesc();
}
