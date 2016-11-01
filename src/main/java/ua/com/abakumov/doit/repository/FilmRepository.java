package ua.com.abakumov.doit.repository;

import ua.com.abakumov.doit.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, String> {
}
