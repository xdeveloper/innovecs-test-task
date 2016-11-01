package ua.com.abakumov.doit.service;

import ua.com.abakumov.doit.domain.Film;

import java.util.Set;

/**
 * Films API
 * <p>
 * (c) 2016
 * Created by air on 01.11.16.
 */
public interface FilmService {

    Film searchById(String id);

    Set<Film> search(String title, String description, String categoryName, String actorName, String languageName);

}