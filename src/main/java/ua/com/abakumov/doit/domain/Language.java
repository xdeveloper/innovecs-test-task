package ua.com.abakumov.doit.domain;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.common.base.Objects;
import lombok.Data;
import ua.com.abakumov.doit.json.View;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * (c) 2016
 * Created by air on 01.11.16.
 */

@Data
@Entity
@Table(name = "language")
public class Language {

    @Id
    @NotNull
    @Column(name = "language_id", nullable = false, updatable = false)
    private String id;

    @NotNull
    @Column(name = "name", nullable = false)
    @JsonView(View.Standard.class)
    private String name;
}
