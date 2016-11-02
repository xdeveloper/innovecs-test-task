package ua.com.abakumov.doit.domain;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import ua.com.abakumov.doit.json.View;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * (c) 2016
 * Created by air on 01.11.16.
 */

@Data
@Entity
public class Film {

    @Id
    @NotNull
    @Column(name = "film_id", nullable = false, updatable = false)
    @JsonView(View.Standard.class)
    private String id;

    @NotNull
    @Column(name = "title", nullable = false)
    @JsonView(View.Standard.class)
    private String title;

    @NotNull
    @Column(name = "description", nullable = false)
    @JsonView(View.Standard.class)
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "language_id")
    private Language language;

    @Column(name = "release_year")
    @JsonView(View.Standard.class)
    private String releaseYear;

    @Column(name = "length")
    @JsonView(View.Standard.class)
    private String length;

    @Column(name = "rating")
    @JsonView(View.Standard.class)
    private String rating;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    @JsonView(View.Standard.class)
    private Category category;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    @JsonView(View.Standard.class)
    private Set<Actor> actors;
}
