package ua.com.abakumov.doit.repository;

import org.springframework.stereotype.Repository;
import ua.com.abakumov.doit.domain.Actor;
import ua.com.abakumov.doit.domain.Category;
import ua.com.abakumov.doit.domain.Film;
import ua.com.abakumov.doit.domain.Language;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class FilmRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Film> search(Optional<String> title, Optional<String> description, Optional<String> categoryName, Optional<String> actorLastName, Optional<String> languageName) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Film> cq = cb.createQuery(Film.class);
        Root<Film> root = cq.from(Film.class);

        // Build predicates
        List<Predicate> predicates = new ArrayList<>();
        addToPredicates(predicates, title, (x) -> cb.equal(root.get("title"), x));
        addToPredicates(predicates, description, (x) -> cb.equal(root.get("description"), x));
        addToPredicates(predicates, categoryName, (x) -> {
            Join<Film, Category> category = root.join("category");
            return cb.equal(category.get("name"), x);
        });
        addToPredicates(predicates, actorLastName, (x) -> {
            Join<Film, Actor> actors = root.join("actors");
            return cb.equal(actors.get("lastName"), x);
        });
        addToPredicates(predicates, languageName, (x) -> {
            Join<Film, Language> language = root.join("language");
            return cb.equal(language.get("name"), x);
        });

        // Build where clause
        if (!predicates.isEmpty()) {
            cq.where(collectPredicates(predicates));
        }

        return entityManager.createQuery(cq).getResultList();
    }

    private void addToPredicates(List<Predicate> predicates, Optional<String> opt, Function<String, Predicate> f) {
        if (opt.isPresent()) {
            Predicate predicate = f.apply(opt.get());
            predicates.add(predicate);
        }
    }

    private static Predicate[] collectPredicates(List<Predicate> predicates) {
        int size = predicates.size();
        Predicate[] array = new Predicate[size];
        for (int i = 0; i < predicates.size(); i++) {
            array[i] = predicates.get(i);
        }

        return array;
    }

    public Film findOne(String id) {
        return entityManager.find(Film.class, id);
    }
}
