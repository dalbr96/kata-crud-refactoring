package co.com.sofka.crud.assembler;

import co.com.sofka.crud.dto.CategoryDTO;
import co.com.sofka.crud.dto.TodoDTO;
import co.com.sofka.crud.model.Category;
import co.com.sofka.crud.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class Assembler {

    public static TodoDTO makeTodoDTO (Todo todo){
        TodoDTO todoDTO = new TodoDTO();

        todoDTO.setCategoryId(todo.getCategory().getId());
        todoDTO.setCategoryName(todo.getCategory().getName());
        todoDTO.setTodoID(todo.getId());
        todoDTO.setTodoName(todo.getName());
        todoDTO.setTodoCompleted(todo.isCompleted());

        return todoDTO;
    }

    public static CategoryDTO makeCategoryDTO(Category category){

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());

        List<TodoDTO> todosDTO = new ArrayList<>();

        for(Todo todo: category.getTodos()){

            todosDTO.add(makeTodoDTO(todo));
        }

        categoryDTO.setTodos(todosDTO);

        return categoryDTO;
    }
}
