package tech.itpark.kinoposik.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tech.itpark.kinoposik.model.Actor;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Long> {
    @Query
    Optional<Actor> findActorByName(String name);

    @Query
    Iterable<Actor> findAllByIsDeletedFalse();

    @Modifying
    @Transactional
    @Query("update Actor a set a.isDeleted = true where a.id = :id")
    void deleteActorById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("update Actor a set a.name = :name, a.age = :age, a.imageUrl = :imageUrl where a.id = :id")
    void updateActorById(@Param("id") Long id,
                         @Param("name") String name,
                         @Param("age") int age,
                         @Param("imageUrl") String imageUrl);

    @Query(value = "select a.id from Actor a where a.name in :actorNames")
    List<Long> findActorIdByName(@Param("actorNames") Collection<String> actorNames);

    @Query(value = "select a from Actor a where a.name in :actorNames")
    Iterable<Actor> findActorsByName(@Param("actorNames") Collection<String> actorNames);

    @Query(value = "select a from Actor a where lower(a.name) like %:name%")
    Iterable<Actor> searchActorsByName(@Param("name") String name);
}
