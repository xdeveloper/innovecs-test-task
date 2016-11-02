package ua.com.abakumov.doit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.abakumov.doit.domain.Category;

import java.util.List;

/**
 * (c) 2016
 * Created by air on 02.11.16.
 */
public interface CategoryRepository extends JpaRepository<Category, String> {
    List<Category> findAllByOrderByNameAsc();
}
