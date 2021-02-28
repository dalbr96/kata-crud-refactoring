package co.com.sofka.crud.dto;

import co.com.sofka.crud.model.Category;
import co.com.sofka.crud.model.Todo;

import java.util.List;

public class InterfazDTO {

    private Iterable<Todo> todos;
    private Iterable<Category> categories;

    public Iterable<Todo> getTodos() {
        return todos;
    }

    public void setTodos(Iterable<Todo> todos) {
        this.todos = todos;
    }

    public Iterable<Category> getCategories() {
        return categories;
    }

    public void setCategories(Iterable<Category> categories) {
        this.categories = categories;
    }
}
