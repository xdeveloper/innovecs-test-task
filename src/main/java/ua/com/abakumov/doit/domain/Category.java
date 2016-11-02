package ua.com.abakumov.doit.domain;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import ua.com.abakumov.doit.json.View;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * (c) 2016
 * Created by air on 01.11.16.
 */

@Data
@Entity
@Table(name = "category")
public class Category {

    @Id
    @NotNull
    @Column(name = "category_id", nullable = false, updatable = false)
    private String id;

    @NotNull
    @Column(name = "name", nullable = false)
    @JsonView(View.Standard.class)
    private String name;

    @NotNull
    @Column(name = "last_update", nullable = false)
    private String lastUpdate;
    
}
