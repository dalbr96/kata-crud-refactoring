package co.com.sofka.crud.assembler;

import co.com.sofka.crud.dto.TodoDTO;
import co.com.sofka.crud.model.Todo;

public class Assembler {

    public static TodoDTO makeTodoDTO(Todo todo) {
        TodoDTO todoDTO = new TodoDTO();

        todoDTO.setName(todo.getName());
        todoDTO.setId(todo.getId());
        todoDTO.setCategoryId(todo.getCategory().getId());
        todoDTO.setCompleted(todo.isCompleted());

        return todoDTO;
    }

    public static Todo makeTodo(TodoDTO todoDTO){

        Todo todo = new Todo();

        todo.setId(todoDTO.getId());
        todo.setName(todoDTO.getName());
        todo.setCompleted(todoDTO.isCompleted());

        return todo;
    }
}
