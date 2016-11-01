package javabeat.net.springboot.repository;

import javabeat.net.springboot.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, String> {
}
