package tech.itpark.kinoposik.service;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import tech.itpark.kinoposik.model.*;
import tech.itpark.kinoposik.repository.*;
import tech.itpark.kinoposik.util.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class MovieService {
    private final ActorRepository actorRepository;
    private final MovieRepository movieRepository;

    public MovieService(ActorRepository actorRepository, MovieRepository movieRepository) {
        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(
            String name,
            String imageUrl,
            String duration,
            String year,
            String country,
            String stageDirector,
            List<String> genre,
            List<String> actor
    ) {
        int parsedDuration = Integer.parseInt(duration);
        int parsedYear = Integer.parseInt(year);
        Movie m = new Movie(name, imageUrl, parsedDuration, parsedYear, country, stageDirector, genre);
        movieRepository.save(m);
        updateActorsByMovieId(m.getId(), actor);
        return m;
    }

    private void updateActorsByMovieId(Long id, List<String> actor) {
        for (String a : actor) {
            if (actorRepository.findActorByName(a).isEmpty()) {
                actorRepository.save(new Actor(a));
            }
        }
        List<Long> actorsId = actorRepository.findActorIdByName(actor);
        for (Long actorId : actorsId) {
            movieRepository.updateActorById(id, actorId);
        }
    }

    public boolean isInputYearValid(String year) {
        try {
            Integer.parseInt(year);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isInputDurationValid(String duration) {
        try {
            Integer.parseInt(duration);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public Iterable<Movie> getAllMovies() {
        return movieRepository.findAllByIsDeletedFalse();
    }

    public void deleteMovieById(Long id) {
        movieRepository.deleteMovieById(id);
    }

    public Optional<Movie> editMovieById(
            Long id,
            String name,
            String imageUrl,
            String year,
            String duration,
            String country,
            String stageDirector,
            List<String> genre,
            List<String> actor
    ) {
        int parsedDuration = Integer.parseInt(duration);
        int parsedYear = Integer.parseInt(year);
        movieRepository.updateMovieById(id, name, imageUrl, parsedYear, parsedDuration, country, stageDirector);
        movieRepository.deleteGenreById(id);
        movieRepository.deleteActorById(id);
        for (String g : genre) {
            movieRepository.updateGenreById(id, g);
        }
        updateActorsByMovieId(id, actor);
        return movieRepository.findById(id);
    }

    public boolean isActorExist(String name) {
        Optional<Actor> actorByName = actorRepository.findActorByName(name);
        return actorByName.isPresent();
    }

    public Iterable<Movie> filterMovieByCountry(String country) {
        return movieRepository.findAllByIsDeletedFalseAndCountry(country);
    }

    public Iterable<Movie> filterMovieByGenre(String genre) {
        List<Long> moviesIdByGenre = movieRepository.findMoviesIdByGenre(genre);
        return movieRepository.findAllById(moviesIdByGenre);
    }

    public Iterable<Movie> filterMovieByActor(String name) {
        Optional<Actor> actorByName = actorRepository.findActorByName(name);
        Long id;
        List<Long> moviesIdByActor = new ArrayList<>();
        if (actorByName.isPresent()) {
            id = actorByName.get().getId();
            moviesIdByActor = movieRepository.findMoviesIdByActor(id, 30);
        }
        return movieRepository.findAllById(moviesIdByActor);
    }

    public Iterable<Movie> orderMovieByIdDesc() {
        return movieRepository.findAllByIsDeletedFalseOrderByIdDesc();
    }

    public Iterable<Movie> orderMovieByName() {
        return movieRepository.findAllByIsDeletedFalseOrderByName();
    }

    public Iterable<Movie> orderMovieByNameDesc() {
        return movieRepository.findAllByIsDeletedFalseOrderByNameDesc();
    }

    public Iterable<Movie> orderMovieByYear() {
        return movieRepository.findAllByIsDeletedFalseOrderByYear();
    }

    public Iterable<Movie> orderMovieByYearDesc() {
        return movieRepository.findAllByIsDeletedFalseOrderByYearDesc();
    }

    public Iterable<Movie> searchMovieByParameters(String name, String yearStart, String yearEnd, String country) {
        int parsedYearStart = 1900;
        int parsedYearEnd = Year.now().getValue() + 3;
        if (!yearStart.isBlank()) {
                parsedYearStart = Integer.parseInt(yearStart);
        }
        if (!yearEnd.isBlank()) {
                parsedYearEnd = Integer.parseInt(yearEnd);
        }
        MovieSpecification spec1 =
                new MovieSpecification(new MovieSearchCriteria("name"+"%", ":", "%"+name+"%"));
        MovieSpecification spec2 =
                new MovieSpecification(new MovieSearchCriteria("year", ">", parsedYearStart));
        MovieSpecification spec3 =
                new MovieSpecification(new MovieSearchCriteria("year", "<", parsedYearEnd));
        MovieSpecification spec4 =
                new MovieSpecification(new MovieSearchCriteria("country", ":", country));

        return movieRepository.findAll(Specification.where(spec1).and(spec2).and(spec3).and(spec4));
    }
}
