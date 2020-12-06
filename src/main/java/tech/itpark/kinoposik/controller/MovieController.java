package tech.itpark.kinoposik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.itpark.kinoposik.model.Actor;
import tech.itpark.kinoposik.model.Movie;
import tech.itpark.kinoposik.repository.ActorRepository;
import tech.itpark.kinoposik.repository.MovieRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/movie")
public class MovieController {
    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;

    public MovieController(MovieRepository movieRepository, ActorRepository actorRepository) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
    }

    @GetMapping("/add")
    public String addMovie() {
        return "movies/add";
    }

    @PostMapping("/add")
    public String addMovie(@RequestParam String name,
                           @RequestParam String imageUrl,
                           @RequestParam int duration,
                           @RequestParam int year,
                           @RequestParam String country,
                           @RequestParam String stageDirector,
                           @RequestParam List<String> genre,
                           @RequestParam List<String> actor,
                           Model model
    ) {
        Movie m = new Movie(name, imageUrl, duration, year, country, stageDirector, genre);
        movieRepository.save(m);
        List<String> incorrectActorName = new ArrayList<>();
        List<String> correctActorName = new ArrayList<>();
        for (String s : actor) {
            if (actorRepository.findActorByName(s).isEmpty()) {
                incorrectActorName.add(s);
                continue;
            }
            correctActorName.add(s);
        }
        List<Long> actorsId = actorRepository.findActorIdByName(correctActorName);
        model.addAttribute("movie_id", m.getId());
        model.addAttribute("incorrectNames", incorrectActorName);
        for (Long aLong : actorsId) {
            movieRepository.updateActorById(m.getId(), aLong);
        }
        if (incorrectActorName.size() > 0) {
            return "errors/invalidActor";
        }

        return "redirect:/movie/" + m.getId();
    }

    @GetMapping("/{id}")
    public String getMovie(@PathVariable Long id, Model model) {
        Optional<Movie> movie = movieRepository.findById(id);
        model.addAttribute("movie", movie);

        return "movies/movie";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        Iterable<Movie> movies = movieRepository.findAllWithoutDeleted();
        model.addAttribute("movies", movies);

        return "movies/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovieById(@PathVariable Long id, Model model) {
        movieRepository.deleteMovieById(id);
        Iterable<Movie> movies = movieRepository.findAllWithoutDeleted();
        model.addAttribute("movies", movies);
        return "movies/all";
    }

    @GetMapping("/edit/{id}")
    public String editMovie(@PathVariable Long id, Model model) {
        Optional<Movie> movie = movieRepository.findById(id);
        model.addAttribute("movie", movie);

        return "movies/edit";
    }

    @PostMapping("/edit/{id}")
    public String editMovie(@PathVariable Long id,
                            @RequestParam("name") String name,
                            @RequestParam("imageUrl") String imageUrl,
                            @RequestParam("year") int year,
                            @RequestParam("duration") int duration,
                            @RequestParam("country") String country,
                            @RequestParam("stageDirector") String stageDirector,
                            @RequestParam("genre") List<String> genre,
                            @RequestParam("actor") List<String> actor,
                            Model model
    ) {
        movieRepository.updateMovieById(id, name, imageUrl, year, duration, country, stageDirector);
        movieRepository.deleteGenreById(id);
        movieRepository.deleteActorById(id);
        for (String g : genre) {
            movieRepository.updateGenreById(id, g);
        }
        List<Long> actorsId = actorRepository.findActorIdByName(actor);
        for (int i = 0; i < actor.size(); i++) {
            if (actorRepository.findActorByName(actor.get(i)).isEmpty()) {
                model.addAttribute("actor", actor.get(i));
                model.addAttribute("movie_id", id);
                return "errors/invalidActor";
            }
            movieRepository.updateActorById(id, actorsId.get(i));
        }
        Optional<Movie> movie = movieRepository.findById(id);
        model.addAttribute("movie", movie);

        return "redirect:/movie/" + id;
    }


    @GetMapping("/search/country/{country}")
    public String searchByCountry(@PathVariable String country, Model model) {
        Iterable<Movie> allByCountry = movieRepository.findAllByCountry(country);
        model.addAttribute("movies", allByCountry);
        model.addAttribute("country", country);

        return "movies/searchResult";
    }

    @GetMapping("/search/genre/{genre}")
    public String searchByGenre(@PathVariable String genre, Model model) {
        List<Long> moviesIdByGenre = movieRepository.findMoviesIdByGenre(genre);
        Iterable<Movie> allById = movieRepository.findAllById(moviesIdByGenre);
        model.addAttribute("movies", allById);
        model.addAttribute("genre", genre);

        return "movies/searchResult";
    }

    @GetMapping("/search/actor/{actor}")
    public String searchByActor(@PathVariable String actor, Model model) {
        Optional<Actor> actorByName = actorRepository.findActorByName(actor);
        if (actorByName.isEmpty()) {
            return "errors/invalidActor";
        }
        Long id = actorByName.get().getId();
        List<Long> moviesIdByActor = movieRepository.findMoviesIdByActor(id, 30);
        Iterable<Movie> allByActor = movieRepository.findAllById(moviesIdByActor);
        model.addAttribute("movies", allByActor);
        model.addAttribute("actor", actor);

        return "movies/searchResult";
    }
}
