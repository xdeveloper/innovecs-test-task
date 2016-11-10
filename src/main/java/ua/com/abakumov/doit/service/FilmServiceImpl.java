package ua.com.abakumov.doit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ua.com.abakumov.doit.domain.Actor;
import ua.com.abakumov.doit.domain.Category;
import ua.com.abakumov.doit.domain.Film;
import ua.com.abakumov.doit.domain.Language;
import ua.com.abakumov.doit.repository.ActorRepository;
import ua.com.abakumov.doit.repository.CategoryRepository;
import ua.com.abakumov.doit.repository.FilmRepository;
import ua.com.abakumov.doit.repository.LanguageRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

/**
 * (c) 2016
 * Created by air on 01.11.16.
 */
@Service
@SuppressWarnings(value = "unused")
public class FilmServiceImpl implements FilmService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FilmServiceImpl.class);

    private final FilmRepository filmRepository;
    private final CategoryRepository categoryRepository;
    private final ActorRepository actorRepository;
    private final LanguageRepository languageRepository;

    @Inject
    public FilmServiceImpl(
            final FilmRepository filmRepository,
            final CategoryRepository categoryRepository,
            final ActorRepository actorRepository,
            final LanguageRepository languageRepository) {

        this.filmRepository = filmRepository;
        this.categoryRepository = categoryRepository;
        this.actorRepository = actorRepository;
        this.languageRepository = languageRepository;
    }

    @Override
    public Film getFilmById(String id) {
        return filmRepository.findOne(id);
    }

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAllByOrderByNameAsc();
    }

    @Override
    public List<Actor> listActors() {
        return actorRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public List<Language> listLanguages() {
        return languageRepository.findAllByOrderByNameAsc();
    }


    @Override
    public List<Film> searchFilms(Optional<String> title, Optional<String> description, Optional<String> categoryName, Optional<String> actorLastName, Optional<String> languageName) {
        return filmRepository.search(title, description, categoryName, actorLastName, languageName);
    }





}
