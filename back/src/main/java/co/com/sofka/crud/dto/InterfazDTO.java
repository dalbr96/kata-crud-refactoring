package co.com.sofka.crud.dto;

import co.com.sofka.crud.model.Category;
import co.com.sofka.crud.model.Todo;

import java.util.List;

public class InterfazDTO {

    private Iterable<TodoDTO> todos;
    private Iterable<CategoryDTO> categories;

    public Iterable<TodoDTO> getTodos() {
        return todos;
    }

    public void setTodos(Iterable<TodoDTO> todos) {
        this.todos = todos;
    }

    public Iterable<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(Iterable<CategoryDTO> categories) {
        this.categories = categories;
    }
}
