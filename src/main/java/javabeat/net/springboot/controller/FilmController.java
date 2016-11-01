package javabeat.net.springboot.controller;

import javabeat.net.springboot.domain.Film;
import javabeat.net.springboot.service.FilmService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Set;

@SuppressWarnings(value = "unused")
@RestController
public class FilmController {

    private final FilmService service;

    @Inject
    public FilmController(final FilmService service) {
        this.service = service;
    }

    @RequestMapping(value = "/film/{id}", method = RequestMethod.GET)
    public Film get(@PathVariable(value = "id") String id) {
        Film film = service.searchById(id);
        return film;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Set<Film> search(@RequestParam(value = "title", required = false) String title,
                            @RequestParam(value = "description", required = false) String description,
                            @RequestParam(value = "categoryName", required = false) String categoryName,
                            @RequestParam(value = "actorName", required = false) String actorName,
                            @RequestParam(value = "languageName", required = false) String languageName) {

        Set<Film> films = service.search(title, description, categoryName, actorName, languageName);
        return films;
    }
}
