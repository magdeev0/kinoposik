package tech.itpark.kinoposik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.itpark.kinoposik.manager.ActorManager;

@Controller
@RequestMapping("/actor")
public class ActorController {
    private final ActorManager actorManager;

    public ActorController(ActorManager actorManager) {
        this.actorManager = actorManager;
    }

    @GetMapping("/add")
    public String addActor() {
        return "actors/add";
    }

    @PostMapping("/add")
    public String addActor(@RequestParam String name,
                           @RequestParam int age,
                           @RequestParam String imageUrl
    ) {
        return actorManager.addActor(name, age, imageUrl);
    }

    @GetMapping("/{id}")
    public String getActorById(@PathVariable Long id, Model model) {
        return actorManager.getActorById(id, model);
    }

    @GetMapping("/all")
    public String getAllActors(Model model) {
        return actorManager.getAllActors(model);
    }

    @GetMapping("/delete/{id}")
    public String deleteActorById(@PathVariable Long id, Model model) {
        return actorManager.deleteActorById(id, model);
    }

    @GetMapping("/edit/{id}")
    public String editActorById(@PathVariable Long id, Model model) {
        return actorManager.editActorById(id, model);
    }

    @PostMapping("/edit/{id}")
    public String editActorById(@PathVariable Long id,
                                @RequestParam String name,
                                @RequestParam int age,
                                @RequestParam String imageUrl,
                                Model model
    ) {
        return actorManager.editActorById(id, name, age, imageUrl, model);
    }

    @GetMapping("/search")
    public String searchActorByName() {
        return "actors/search";
    }

    @PostMapping("/search")
    public String searchResultActorByName(@RequestParam String name, Model model) {
        return actorManager.searchResultActorByName(name, model);
    }
}
