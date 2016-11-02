package ua.com.abakumov.doit.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ua.com.abakumov.doit.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, String>, JpaSpecificationExecutor<Film> {
}
