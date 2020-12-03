package tech.itpark.kinoposik.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tech.itpark.kinoposik.model.Actor;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Long> {
    @Query("select a from Actor a where a.isDeleted = false")
    Iterable<Actor> findAllWithoutDeleted();

    @Modifying
    @Transactional
    @Query("update Actor a set a.isDeleted = true where a.id = :id")
    void updateActorById(@Param("id") Long id);
}
