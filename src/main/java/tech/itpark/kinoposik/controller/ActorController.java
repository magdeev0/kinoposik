package tech.itpark.kinoposik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.itpark.kinoposik.model.Actor;
import tech.itpark.kinoposik.repository.ActorRepository;

import java.util.Optional;

@Controller
@RequestMapping("/actor")
public class ActorController {
    private final ActorRepository actorRepository;

    public ActorController(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @GetMapping("/add")
    public String addActor() {
        return "actors/add";
    }

    @PostMapping("/add")
    public String addActor(@RequestParam String name,
                           @RequestParam String imageUrl,
                           @RequestParam int age,
                           Model model
    ) {
        Actor a = new Actor(name, age, imageUrl);
        actorRepository.save(a);

        return "redirect:/actor/" + a.getId();
    }

    @GetMapping("/{id}")
    public String getActor(@PathVariable Long id,
                           Model model
    ) {
        Optional<Actor> actor = actorRepository.findById(id);
        model.addAttribute("actor", actor);

        return "actors/actor";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        Iterable<Actor> actors = actorRepository.findAllWithoutDeleted();
        model.addAttribute("actors", actors);

        return "actors/index";
    }
}
