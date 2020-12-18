package tech.itpark.kinoposik.service;

import org.springframework.stereotype.Service;
import tech.itpark.kinoposik.model.*;
import tech.itpark.kinoposik.repository.*;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class ActorService {
    private final ActorRepository actorRepository;
    private final MovieRepository movieRepository;

    public ActorService(ActorRepository actorRepository, MovieRepository movieRepository) {
        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
    }

    public Actor addActor(String name, String age, String imageUrl) {
        int parsedAge = Integer.parseInt(age);
        Actor a = new Actor(name, parsedAge, imageUrl);
        actorRepository.save(a);
        return a;
    }

    public boolean isInputAgeValid(String age) {
        try {
            Integer.parseInt(age);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Optional<Actor> getActorById(Long id) {
        return actorRepository.findById(id);
    }

    public Iterable<Movie> getMoviesByActor(Long id) {
        int limit = 5;
        List<Long> moviesId = movieRepository.findMoviesIdByActor(id, limit);
        return movieRepository.findAllById(moviesId);
    }

    public Iterable<Actor> getAllActors() {
        return actorRepository.findAllByIsDeletedFalse();
    }

    public void deleteActorById(Long id) {
        actorRepository.deleteActorById(id);
    }

    public void editActorById(Long id, String name, String age, String imageUrl) {
        int parsedAge = Integer.parseInt(age);
        actorRepository.updateActorById(id, name, parsedAge, imageUrl);
    }

    public Iterable<Actor> searchResultActorByName(String name) {
        String toLower = name.toLowerCase(Locale.ROOT);
        return actorRepository.searchActorsByName(toLower);
    }
}
