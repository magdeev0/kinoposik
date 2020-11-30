package tech.itpark.kinoposik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.itpark.kinoposik.model.Actor;
import tech.itpark.kinoposik.model.Movie;
import tech.itpark.kinoposik.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/movie")
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @RequestMapping("/add1")
    public @ResponseBody
    Movie addNewUser(
            @RequestParam String name,
            @RequestParam String imageUrl,
            @RequestParam int duration,
            @RequestParam int year,
            @RequestParam String country,
            @RequestParam String stageDirector,
            @RequestParam List<String> genre,
            @RequestParam List<Actor> actor
    ) {
        Movie m = new Movie();
        m.setName(name);
        m.setImageUrl(imageUrl);
        m.setDuration(duration);
        m.setYear(year);
        m.setCountry(country);
        m.setStageDirector(stageDirector);
        m.setGenre(genre);
        m.setActor(actor);
        movieRepository.save(m);
        return m;
    }

    @GetMapping("/get/{id}")
    public @ResponseBody
    Optional<Movie> getMovie(@PathVariable Long id) {
        return movieRepository.findById(id);
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
                           @RequestParam List<Actor> actor,
                           Model model
    ) {
        Movie m = new Movie(name, imageUrl, duration, year, country, stageDirector, genre, actor);
        movieRepository.save(m);
        model.addAttribute("genres", genre);

        return "redirect:/movie/" + m.getId();
    }

    @GetMapping("/{id}")
    public String getMovie(@PathVariable Long id,
                           Model model
    ) {
        Optional<Movie> movie = movieRepository.findById(id);
        model.addAttribute("movie", movie);

        return "movies/movie";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        Iterable<Movie> movies = movieRepository.findAllWithoutDeleted();
        model.addAttribute("movies", movies);

        return "movies/index";
    }

    @GetMapping("/search/country/{country}")
    public String searchByCountry(@PathVariable String country,
                                           Model model
    ) {
        Iterable<Movie> allByCountry = movieRepository.findAllByCountry(country);
        model.addAttribute("movies", allByCountry);
        model.addAttribute("country", country);

        return "movies/searchResult";
    }
}
