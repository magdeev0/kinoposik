package tech.itpark.kinoposik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.itpark.kinoposik.service.ActorService;

@Controller
@RequestMapping("/actor")
public class ActorController {
    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/add")
    public String addActor() {
        return "actors/add";
    }

    @PostMapping("/add")
    public String addActor(
            @RequestParam String name,
            @RequestParam String age,
            @RequestParam String imageUrl,
            Model model
    ) {
        if (!actorService.isInputAgeValid(age)) {
            model.addAttribute("error", age);
            return "errors/invalidInput";
        }
        return "redirect:/actor/" + actorService.addActor(name, age, imageUrl).getId();
    }

    @GetMapping("/{id}")
    public String getActorById(@PathVariable Long id, Model model) {
        model.addAttribute("actor", actorService.getActorById(id));
        if (actorService.getMoviesByActor(id).iterator().hasNext()) {
            model.addAttribute("movies", actorService.getMoviesByActor(id));
        }
        return "actors/actor";
    }

    @GetMapping("/all")
    public String getAllActors(Model model) {
        model.addAttribute("actors", actorService.getAllActors());
        return "actors/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteActorById(@PathVariable Long id, Model model) {
        actorService.deleteActorById(id);
        model.addAttribute("actors", actorService.getAllActors());
        return "redirect:/actor/all";
    }

    @GetMapping("/edit/{id}")
    public String editActorById(@PathVariable Long id, Model model) {
        model.addAttribute("actor", actorService.getActorById(id));
        return "actors/edit";
    }

    @PostMapping("/edit/{id}")
    public String editActorById(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam String age,
            @RequestParam String imageUrl,
            Model model
    ) {
        if (!actorService.isInputAgeValid(age)) {
            model.addAttribute("error", age);
            return "errors/invalidInput";
        }
        actorService.editActorById(id, name, age, imageUrl);
        model.addAttribute("actor", actorService.getActorById(id));
        return "redirect:/actor/" + id;
    }

    @GetMapping("/search")
    public String searchActorByName() {
        return "actors/search";
    }

    @PostMapping("/search")
    public String searchResultActorByName(@RequestParam String name, Model model) {
        model.addAttribute("searchedName", name);
        if (!actorService.searchResultActorByName(name).iterator().hasNext()) {
            model.addAttribute("searchError", true);
            return "actors/searchResult";
        }
        model.addAttribute("actors", actorService.searchResultActorByName(name));
        return "actors/searchResult";
    }
}
