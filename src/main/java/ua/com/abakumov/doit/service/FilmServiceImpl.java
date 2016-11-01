package ua.com.abakumov.doit.service;

import ua.com.abakumov.doit.domain.Film;
import ua.com.abakumov.doit.repository.FilmRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Set;

/**
 * (c) 2016
 * Created by air on 01.11.16.
 */
@Service
@SuppressWarnings(value = "unused")
public class FilmServiceImpl implements FilmService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FilmServiceImpl.class);

    private final FilmRepository repository;

    @Inject
    public FilmServiceImpl(final FilmRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    @Override
    public Film searchById(String id) {
        return repository.findOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Set<Film> search(String title, String description, String categoryName, String actorName, String languageName) {
        return null;
    }
}