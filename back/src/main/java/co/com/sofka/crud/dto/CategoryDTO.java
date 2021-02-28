package co.com.sofka.crud.dto;

import co.com.sofka.crud.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTO {

    private String name;
    private Long id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
