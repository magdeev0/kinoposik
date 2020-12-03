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

        return "movies/all";
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

    @GetMapping("/search/genre/{genre}")
    public String searchByGenre(@PathVariable String genre,
                                Model model
    ) {
        List<Long> moviesIdByGenre = movieRepository.findMoviesIdByGenre(genre);
        Iterable<Movie> allById = movieRepository.findAllById(moviesIdByGenre);
        model.addAttribute("movies", allById);
        model.addAttribute("genre", genre);

        return "movies/searchResult";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovieById(@PathVariable Long id, Model model) {
        movieRepository.updateMovieById(id);
        Iterable<Movie> movies = movieRepository.findAllWithoutDeleted();
        model.addAttribute("movies", movies);
        return "movies/all";
    }
}
