package ua.com.abakumov.doit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.abakumov.doit.domain.Actor;

import java.util.List;

/**
 * (c) 2016
 * Created by air on 02.11.16.
 */
public interface ActorRepository extends JpaRepository<Actor, String> {
    List<Actor> findAllByOrderByLastNameAsc();
}
