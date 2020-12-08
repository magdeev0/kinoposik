package tech.itpark.kinoposik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.itpark.kinoposik.model.Actor;
import tech.itpark.kinoposik.model.Movie;
import tech.itpark.kinoposik.repository.ActorRepository;
import tech.itpark.kinoposik.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/actor")
public class ActorController {
    private final ActorRepository actorRepository;
    private final MovieRepository movieRepository;

    public ActorController(ActorRepository actorRepository, MovieRepository movieRepository) {
        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
    }

    @GetMapping("/add")
    public String addActor() {
        return "actors/add";
    }

    @PostMapping("/add")
    public String addActor(@RequestParam String name,
                           @RequestParam String imageUrl,
                           @RequestParam int age
    ) {
        Actor a = new Actor(name, age, imageUrl);
        actorRepository.save(a);

        return "redirect:/actor/" + a.getId();
    }

    @GetMapping("/{id}")
    public String getActorById(@PathVariable Long id, Model model) {
        int limit = 5;
        Optional<Actor> actor = actorRepository.findById(id);
        List<Long> moviesId = movieRepository.findMoviesIdByActor(id, limit);
        Iterable<Movie> moviesWithActor = movieRepository.findAllById(moviesId);
        model.addAttribute("actor", actor);
        model.addAttribute("movies", moviesWithActor);

        return "actors/actor";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        Iterable<Actor> actors = actorRepository.findAllWithoutDeleted();
        model.addAttribute("actors", actors);

        return "actors/all";
    }

    /*@GetMapping("/delete/{id}")
    public String deleteActorById(@PathVariable Long id, Model model) {
        actorRepository.deleteActorById(id);
        Iterable<Actor> actors = actorRepository.findAllWithoutDeleted();
        model.addAttribute("actors", actors);
        return "actors/all";
    }*/

    @GetMapping("/edit/{id}")
    public String editActor(@PathVariable Long id, Model model) {
        Optional<Actor> actor = actorRepository.findById(id);
        model.addAttribute("actor", actor);

        return "actors/edit";
    }

    @PostMapping("/edit/{id}")
    public String editActor(@PathVariable Long id,
                            @RequestParam String name,
                            @RequestParam int age,
                            @RequestParam String imageUrl,
                            Model model
    ) {
        actorRepository.updateActorById(id, name, age, imageUrl);
        Optional<Actor> actor = actorRepository.findById(id);
        model.addAttribute("actor", actor);

        return "redirect:/actor/" + id;
    }
}
