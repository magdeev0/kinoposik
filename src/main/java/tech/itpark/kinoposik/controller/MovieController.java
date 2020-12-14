package tech.itpark.kinoposik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.itpark.kinoposik.manager.MovieManager;

import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {
    private final MovieManager movieManager;

    public MovieController(MovieManager movieManager) {
        this.movieManager = movieManager;
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
        return movieManager.addMovie(name, imageUrl, duration, year, country, stageDirector, genre, actor, model);
    }

    @GetMapping("/{id}")
    public String getMovieById(@PathVariable Long id, Model model) {
        return movieManager.getMovieById(id, model);
    }

    @GetMapping("/all")
    public String getAllMovies(Model model) {
        return movieManager.getAllMovies(model);
    }

    @GetMapping("/delete/{id}")
    public String deleteMovieById(@PathVariable Long id, Model model) {
        return movieManager.deleteMovieById(id, model);
    }

    @GetMapping("/edit/{id}")
    public String editMovieById(@PathVariable Long id, Model model) {
        return movieManager.editMovieById(id, model);
    }

    @PostMapping("/edit/{id}")
    public String editMovieById(@PathVariable Long id,
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
        return movieManager.editMovieById(id, name, imageUrl, year, duration, country, stageDirector, genre, actor, model);
    }

    @GetMapping("/filter/country/{country}")
    public String filterMovieByCountry(@PathVariable String country, Model model) {
        return movieManager.filterMovieByCountry(country, model);
    }

    @GetMapping("/filter/genre/{genre}")
    public String filterMovieByGenre(@PathVariable String genre, Model model) {
        return movieManager.filterMovieByGenre(genre, model);
    }

    @GetMapping("/filter/actor/{actor}")
    public String filterMovieByActor(@PathVariable String actor, Model model) {
        return movieManager.filterMovieByActor(actor, model);
    }

    @GetMapping("/filter/order-by/{value}")
    public String orderMovieByAttribute(@PathVariable String value, Model model) {
        return movieManager.orderMovieByAttribute(value, model);
    }

    @GetMapping("/search")
    public String searchMovieByName() {
        return "movies/search";
    }

    @PostMapping("/search")
    public String searchResultMovieByParameters(@RequestParam(required = false) String name,
                                                @RequestParam(required = false) String yearStart,
                                                @RequestParam(required = false) String yearEnd,
                                                @RequestParam(required = false) String country,
                                                Model model
    ) {
        return movieManager.searchResultMovieByParameters(name, yearStart, yearEnd, country, model);
    }
}
