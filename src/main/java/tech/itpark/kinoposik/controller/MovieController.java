package tech.itpark.kinoposik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.itpark.kinoposik.model.Movie;
import tech.itpark.kinoposik.service.MovieService;

import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/add")
    public String addMovie() {
        return "movies/add";
    }

    @PostMapping("/add")
    public String addMovie(
            @RequestParam String name,
            @RequestParam String imageUrl,
            @RequestParam String duration,
            @RequestParam String year,
            @RequestParam String country,
            @RequestParam String stageDirector,
            @RequestParam List<String> genre,
            @RequestParam List<String> actor,
            Model model
    ) {
        if (!movieService.isInputYearValid(year)) {
            model.addAttribute("error", year);
            return "errors/invalidInput";
        }
        if (!movieService.isInputDurationValid(duration)) {
            model.addAttribute("error", duration);
            return "errors/invalidInput";
        }
        Movie m = movieService.addMovie(name, imageUrl, duration, year, country, stageDirector, genre, actor);
        return "redirect:/movie/" + m.getId();
    }

    @GetMapping("/{id}")
    public String getMovieById(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movieService.getMovieById(id));
        return "movies/movie";
    }

    @GetMapping("/all")
    public String getAllMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "movies/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovieById(@PathVariable Long id, Model model) {
        movieService.deleteMovieById(id);
        model.addAttribute("movies", movieService.getAllMovies());
        return "redirect:/movie/all";
    }

    @GetMapping("/edit/{id}")
    public String editMovieById(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movieService.getMovieById(id));
        return "movies/edit";
    }

    @PostMapping("/edit/{id}")
    public String editMovieById(
            @PathVariable Long id,
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
        if (!movieService.isInputYearValid(year)) {
            model.addAttribute("error", year);
            return "errors/invalidInput";
        }
        if (!movieService.isInputDurationValid(duration)) {
            model.addAttribute("error", duration);
            return "errors/invalidInput";
        }
        model.addAttribute("movie", movieService.editMovieById(
                id,
                name,
                imageUrl,
                year,
                duration,
                country,
                stageDirector,
                genre,
                actor
        ));
        return "redirect:/movie/" + id;
    }

    @GetMapping("/filter/country/{country}")
    public String filterMovieByCountry(@PathVariable String country, Model model) {
        model.addAttribute("movies", movieService.filterMovieByCountry(country));
        model.addAttribute("country", country);
        return "movies/filterResult";
    }

    @GetMapping("/filter/genre/{genre}")
    public String filterMovieByGenre(@PathVariable String genre, Model model) {
        model.addAttribute("movies", movieService.filterMovieByGenre(genre));
        model.addAttribute("genre", genre);

        return "movies/filterResult";
    }

    @GetMapping("/filter/actor/{name}")
    public String filterMovieByActor(@PathVariable String name, Model model) {
        model.addAttribute("searchedName", name);
        if (!movieService.isActorExist(name)) {
            model.addAttribute("searchError", true);
            return "errors/invalidActor";
        }
        model.addAttribute("movies", movieService.filterMovieByActor(name));
        return "movies/filterResult";
    }

    @GetMapping("/filter/order-by/id")
    public String orderMovieById(Model model) {
        model.addAttribute("value", "id");
        model.addAttribute("movies", movieService.getAllMovies());
        return "movies/filterResult";
    }

    @GetMapping("/filter/order-by/id-desc")
    public String orderMovieByIdDesc(Model model) {
        model.addAttribute("value", "id-desc");
        model.addAttribute("movies", movieService.orderMovieByIdDesc());
        return "movies/filterResult";
    }

    @GetMapping("/filter/order-by/name")
    public String orderMovieByName(Model model) {
        model.addAttribute("value", "name");
        model.addAttribute("movies", movieService.orderMovieByName());
        return "movies/filterResult";
    }

    @GetMapping("/filter/order-by/name-desc")
    public String orderMovieByNameDesc(Model model) {
        model.addAttribute("value", "name-desc");
        model.addAttribute("movies", movieService.orderMovieByNameDesc());
        return "movies/filterResult";
    }

    @GetMapping("/filter/order-by/year")
    public String orderMovieByYear(Model model) {
        model.addAttribute("value", "year");
        model.addAttribute("movies", movieService.orderMovieByYear());
        return "movies/filterResult";
    }

    @GetMapping("/filter/order-by/year-desc")
    public String orderMovieByYearDesc(Model model) {
        model.addAttribute("value", "year-desc");
        model.addAttribute("movies", movieService.orderMovieByYearDesc());
        return "movies/filterResult";
    }

    @GetMapping("/search")
    public String searchMovieByName() {
        return "movies/search";
    }

    @PostMapping("/search")
    public String searchResultMovieByParameters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String yearStart,
            @RequestParam(required = false) String yearEnd,
            @RequestParam(required = false) String country,
            Model model
    ) {
        if (!yearStart.isBlank()) {
            if (!movieService.isInputYearValid(yearStart)) {
                model.addAttribute("error", yearStart);
                return "errors/invalidInput";
            }
        }
        if (!yearEnd.isBlank()) {
            if (!movieService.isInputYearValid(yearEnd)) {
                model.addAttribute("error", yearEnd);
                return "errors/invalidInput";
            }
        }
        model.addAttribute("movies", movieService.searchMovieByParameters(name, yearStart, yearEnd, country));
        return "movies/searchResult";
    }
}
