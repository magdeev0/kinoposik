package tech.itpark.kinoposik.manager;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import tech.itpark.kinoposik.model.Actor;
import tech.itpark.kinoposik.model.Movie;
import tech.itpark.kinoposik.repository.ActorRepository;
import tech.itpark.kinoposik.repository.MovieRepository;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class ActorManager {
    private final ActorRepository actorRepository;
    private final MovieRepository movieRepository;

    public ActorManager(ActorRepository actorRepository, MovieRepository movieRepository) {
        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
    }

    public String addActor(String name, int age, String imageUrl) {
        Actor a = new Actor(name, age, imageUrl);
        actorRepository.save(a);

        return "redirect:/actor/" + a.getId();
    }

    public String getActorById(Long id, Model model) {
        int limit = 5;
        Optional<Actor> actor = actorRepository.findById(id);
        List<Long> moviesId = movieRepository.findMoviesIdByActor(id, limit);
        if (moviesId.size() > 0) {
            Iterable<Movie> moviesWithActor = movieRepository.findAllById(moviesId);
            model.addAttribute("movies", moviesWithActor);
        }
        model.addAttribute("actor", actor);

        return "actors/actor";
    }

    public String getAllActors(Model model) {
        Iterable<Actor> actors = actorRepository.findAllByIsDeletedFalse();
        model.addAttribute("actors", actors);

        return "actors/all";
    }

    public String deleteActorById(Long id, Model model) {
        actorRepository.deleteActorById(id);
        Iterable<Actor> actors = actorRepository.findAllByIsDeletedFalse();
        model.addAttribute("actors", actors);

        return "redirect:/actor/all";
    }

    public String editActorById(Long id, Model model) {
        Optional<Actor> actor = actorRepository.findById(id);
        model.addAttribute("actor", actor);

        return "actors/edit";
    }

    public String editActorById(Long id,
                                String name,
                                int age,
                                String imageUrl,
                                Model model
    ) {
        actorRepository.updateActorById(id, name, age, imageUrl);
        Optional<Actor> actor = actorRepository.findById(id);
        model.addAttribute("actor", actor);

        return "redirect:/actor/" + id;
    }

    public String searchResultActorByName(String name, Model model) {
        String toLower = name.toLowerCase(Locale.ROOT);
        Iterable<Actor> actorsByName = actorRepository.searchActorsByName(toLower);
        model.addAttribute("searchedName", name);
        if (!actorsByName.iterator().hasNext()) {
            model.addAttribute("searchError", true);
            return "actors/searchResult";
        }
        model.addAttribute("actors", actorsByName);

        return "actors/searchResult";
    }
}
