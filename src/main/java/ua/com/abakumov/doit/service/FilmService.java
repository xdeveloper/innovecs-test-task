package ua.com.abakumov.doit.service;

import ua.com.abakumov.doit.domain.Actor;
import ua.com.abakumov.doit.domain.Category;
import ua.com.abakumov.doit.domain.Film;
import ua.com.abakumov.doit.domain.Language;

import java.util.List;

/**
 * Films API
 * <p>
 * (c) 2016
 * Created by air on 01.11.16.
 */
public interface FilmService {

    Film getFilmById(String id);

    List<Film> searchFilms(String title, String description, String categoryName, String actorName, String languageName);

    List<Category> listCategories();

    List<Language> listLanguages();

    List<Actor> listActors();
}
