package tech.itpark.kinoposik.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.itpark.kinoposik.model.Actor;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Long> {
    @Query("select a from Actor a where a.isDeleted = false")
    Iterable<Actor> findAllWithoutDeleted();
}
