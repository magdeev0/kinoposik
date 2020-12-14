package tech.itpark.kinoposik.controller;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.itpark.kinoposik.model.Actor;
import tech.itpark.kinoposik.model.Movie;
import tech.itpark.kinoposik.repository.ActorRepository;
import tech.itpark.kinoposik.repository.MovieRepository;
import tech.itpark.kinoposik.util.MovieSearchCriteria;
import tech.itpark.kinoposik.util.MovieSpecification;

import java.time.Year;
import java.util.*;

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
                           @RequestParam String duration,
                           @RequestParam String year,
                           @RequestParam String country,
                           @RequestParam String stageDirector,
                           @RequestParam List<String> genre,
                           @RequestParam List<String> actor,
                           Model model
    ) {
        int parsedDuration;
        int parsedYear;
        try {
            parsedDuration = Integer.parseInt(duration);
            parsedYear = Integer.parseInt(year);
        } catch (NumberFormatException e) {
            model.addAttribute("error", e.getMessage().substring(19, e.getMessage().length()-1));
            return "errors/invalidInput";
        }
        Movie m = new Movie(name, imageUrl, parsedDuration, parsedYear, country, stageDirector, genre);
        movieRepository.save(m);
        List<String> incorrectActorName = new ArrayList<>();
        for (String s : actor) {
            if (actorRepository.findActorByName(s).isEmpty()) {
                incorrectActorName.add(s);
                Actor a = new Actor(s);
                actorRepository.save(a);
            }
        }
        List<Long> actorsId = actorRepository.findActorIdByName(actor);
        for (Long aLong : actorsId) {
            movieRepository.updateActorById(m.getId(), aLong);
        }
        if (incorrectActorName.size() > 0) {
            Iterable<Actor> incorrectActors = actorRepository.findActorsByName(incorrectActorName);
            model.addAttribute("movie_id", m.getId());
            model.addAttribute("incorrectActors", incorrectActors);
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
    public String getAllMovies(Model model) {
        Iterable<Movie> movies = movieRepository.findAllByIsDeletedFalse();
        model.addAttribute("movies", movies);

        return "movies/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovieById(@PathVariable Long id, Model model) {
        movieRepository.deleteMovieById(id);
        Iterable<Movie> movies = movieRepository.findAllByIsDeletedFalse();
        model.addAttribute("movies", movies);
        return "redirect:/movie/all";
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
                            @RequestParam("year") String year,
                            @RequestParam("duration") String duration,
                            @RequestParam("country") String country,
                            @RequestParam("stageDirector") String stageDirector,
                            @RequestParam("genre") List<String> genre,
                            @RequestParam("actor") List<String> actor,
                            Model model
    ) {
        int parsedDuration;
        int parsedYear;
        try {
            parsedDuration = Integer.parseInt(duration);
            parsedYear = Integer.parseInt(year);
        } catch (NumberFormatException e) {
            model.addAttribute("error", e.getMessage().substring(19, e.getMessage().length()-1));
            return "errors/invalidInput";
        }
        movieRepository.updateMovieById(id, name, imageUrl, parsedYear, parsedDuration, country, stageDirector);
        movieRepository.deleteGenreById(id);
        movieRepository.deleteActorById(id);
        for (String g : genre) {
            movieRepository.updateGenreById(id, g);
        }
        List<String> incorrectActorName = new ArrayList<>();
        for (String s : actor) {
            if (actorRepository.findActorByName(s).isEmpty()) {
                Actor a = new Actor(s);
                actorRepository.save(a);
                incorrectActorName.add(s);
            }
        }
        List<Long> actorsId = actorRepository.findActorIdByName(actor);
        for (Long actorId : actorsId) {
            movieRepository.updateActorById(id, actorId);
        }
        if (incorrectActorName.size() > 0) {
            Iterable<Actor> incorrectActors = actorRepository.findActorsByName(incorrectActorName);
            model.addAttribute("movie_id", id);
            model.addAttribute("incorrectActors", incorrectActors);
            model.addAttribute("edit", "edit");
            return "errors/invalidActor";
        }
        Optional<Movie> movie = movieRepository.findById(id);
        model.addAttribute("movie", movie);

        return "redirect:/movie/" + id;
    }

    @GetMapping("/filter/country/{country}")
    public String filterMovieByCountry(@PathVariable String country, Model model) {
        Iterable<Movie> allByCountry = movieRepository.findAllByIsDeletedFalseAndCountry(country);
        model.addAttribute("movies", allByCountry);
        model.addAttribute("country", country);

        return "movies/filterResult";
    }

    @GetMapping("/filter/genre/{genre}")
    public String filterMovieByGenre(@PathVariable String genre, Model model) {
        List<Long> moviesIdByGenre = movieRepository.findMoviesIdByGenre(genre);
        Iterable<Movie> allById = movieRepository.findAllById(moviesIdByGenre);
        model.addAttribute("movies", allById);
        model.addAttribute("genre", genre);

        return "movies/filterResult";
    }

    @GetMapping("/filter/actor/{actor}")
    public String filterMovieByActor(@PathVariable String actor, Model model) {
        Optional<Actor> actorByName = actorRepository.findActorByName(actor);
        if (actorByName.isEmpty()) {
            model.addAttribute("searchedName", actor);
            model.addAttribute("searchError", true);
            return "errors/invalidActor";
        }
        Long id = actorByName.get().getId();
        List<Long> moviesIdByActor = movieRepository.findMoviesIdByActor(id, 30);
        Iterable<Movie> allByActor = movieRepository.findAllById(moviesIdByActor);
        model.addAttribute("movies", allByActor);
        model.addAttribute("actor", actor);

        return "movies/filterResult";
    }

    @GetMapping("/filter/order-by/{value}")
    public String orderMovieByAttribute(@PathVariable String value, Model model) {
        model.addAttribute("value", value);
        if (value.equalsIgnoreCase("id")) {
            Iterable<Movie> movies = movieRepository.findAllByIsDeletedFalse();
            model.addAttribute("movies", movies);
            return "movies/filterResult";
        }
        if (value.equalsIgnoreCase("id-desc")) {
            Iterable<Movie> movies = movieRepository.findAllByIsDeletedFalseOrderByIdDesc();
            model.addAttribute("movies", movies);
            return "movies/filterResult";
        }
        if (value.equalsIgnoreCase("name")) {
            Iterable<Movie> movies = movieRepository.findAllByIsDeletedFalseOrderByName();
            model.addAttribute("movies", movies);
            return "movies/filterResult";
        }
        if (value.equalsIgnoreCase("name-desc")) {
            Iterable<Movie> movies = movieRepository.findAllByIsDeletedFalseOrderByNameDesc();
            model.addAttribute("movies", movies);
            return "movies/filterResult";
        }
        if (value.equalsIgnoreCase("year")) {
            Iterable<Movie> movies = movieRepository.findAllByIsDeletedFalseOrderByYear();
            model.addAttribute("movies", movies);
            return "movies/filterResult";
        }
        if (value.equalsIgnoreCase("year-desc")) {
            Iterable<Movie> movies = movieRepository.findAllByIsDeletedFalseOrderByYearDesc();
            model.addAttribute("movies", movies);
            return "movies/filterResult";
        }

        return "movies/filterResult";
    }

    @GetMapping("/search")
    public String searchMovieByName() {
        return "movies/search";
    }

    @PostMapping("/search")
    public String searchResultByParameters(@RequestParam(required = false) String name,
                                           @RequestParam(required = false) String yearStart,
                                           @RequestParam(required = false) String yearEnd,
                                           @RequestParam(required = false) String country,
                                           Model model
    ) {
        int parsedYearStart = 1900;
        int parsedYearEnd = Year.now().getValue()+3;
        if (!yearStart.isBlank()) {
            try {
                parsedYearStart = Integer.parseInt(yearStart);
            } catch (NumberFormatException e) {
                model.addAttribute("error", e.getMessage().substring(19, e.getMessage().length()-1));
                return "/errors/invalidInput";
            }
        }
        if (!yearEnd.isBlank()) {
            try {
            parsedYearEnd = Integer.parseInt(yearEnd);
            } catch (NumberFormatException e) {
                model.addAttribute("error", e.getMessage().substring(19, e.getMessage().length()-1));
                return "/errors/invalidInput";
            }
        }
        MovieSpecification spec1 =
                new MovieSpecification(new MovieSearchCriteria("name", ":", name));
        MovieSpecification spec2 =
                new MovieSpecification(new MovieSearchCriteria("year", ">", parsedYearStart));
        MovieSpecification spec3 =
                new MovieSpecification(new MovieSearchCriteria("year", "<", parsedYearEnd));
        MovieSpecification spec4 =
                new MovieSpecification(new MovieSearchCriteria("country", ":", country));

        Iterable<Movie> movies = movieRepository.findAll(Specification.where(spec1).and(spec2).and(spec3).and(spec4));
        model.addAttribute("movies", movies);
        return "movies/searchResult";
    }
}
