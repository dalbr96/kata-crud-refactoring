package co.com.sofka.crud.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Category {

    @Id
    @GeneratedValue
    Long id;

    @NotNull(message = "You must provide a category")
    @NotBlank(message = "You must provide a category")
    String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
