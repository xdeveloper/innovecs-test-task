package ua.com.abakumov.doit.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.com.abakumov.doit.domain.Actor;
import ua.com.abakumov.doit.domain.Category;
import ua.com.abakumov.doit.domain.Film;
import ua.com.abakumov.doit.domain.Language;
import ua.com.abakumov.doit.json.View;
import ua.com.abakumov.doit.service.FilmService;

import javax.inject.Inject;
import java.util.List;

import static java.util.Optional.ofNullable;

@SuppressWarnings(value = "unused")
@RestController
public class FilmController {

    private final FilmService service;

    @Inject
    public FilmController(final FilmService service) {
        this.service = service;
    }

    @JsonView(View.Standard.class)
    @GetMapping(value = "/film/{id}")
    public Film get(@PathVariable(value = "id") String id) {
        return service.getFilmById(id);
    }

    @GetMapping(value = "/searchFilms")
    public List<Film> search(@RequestParam(value = "title", required = false) String title,
                             @RequestParam(value = "description", required = false) String description,
                             @RequestParam(value = "categoryName", required = false) String categoryName,
                             @RequestParam(value = "actorName", required = false) String actorName,
                             @RequestParam(value = "languageName", required = false) String languageName) {

        return service.searchFilms(
                ofNullable(title),
                ofNullable(description),
                ofNullable(categoryName),
                ofNullable(actorName),
                ofNullable(languageName));
    }

    @GetMapping(value = "/categories")
    public List<Category> categories() {
        return service.listCategories();
    }

    @GetMapping(value = "/actors")
    public List<Actor> actors() {
        return service.listActors();
    }

    @GetMapping(value = "/languages")
    public List<Language> languages() {
        return service.listLanguages();
    }
}
