package ua.com.abakumov.doit.domain;

import com.google.common.base.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * (c) 2016
 * Created by air on 01.11.16.
 */

@Entity
@Table(name = "language")
public class Language {

    @Id
    @NotNull
    @Column(name = "language_id", nullable = false, updatable = false)
    private String id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;


    Language() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
