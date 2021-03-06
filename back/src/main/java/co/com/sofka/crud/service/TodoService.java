package co.com.sofka.crud.service;

import co.com.sofka.crud.assembler.Assembler;
import co.com.sofka.crud.dto.TodoDTO;
import co.com.sofka.crud.model.Todo;
import co.com.sofka.crud.repository.CategoryRepository;
import co.com.sofka.crud.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<TodoDTO> list(){

        Iterable<Todo> todos = todoRepository.findAll();

        List<TodoDTO> todosDTO = new ArrayList<>();

        for(Todo todo: todos){
            todosDTO.add(Assembler.makeTodoDTO(todo));
        }

        return todosDTO;
    }

    public TodoDTO save(TodoDTO todoDTO){

        Todo todo = Assembler.makeTodo(todoDTO);
        todo.setCategory(categoryRepository.findById(todoDTO.getCategoryId()).orElseThrow());

        Todo todoCreado = todoRepository.save(todo);

        TodoDTO TodoDTOCreado = Assembler.makeTodoDTO(todoCreado);

        return TodoDTOCreado;
    }

    public void delete(Long id){
        todoRepository.delete(get(id));
    }

    public Todo get(Long id){
         return todoRepository.findById(id).orElseThrow();
    }

    public TodoDTO getDTO(Long id){

        Todo todo = get(id);

        return Assembler.makeTodoDTO(todo);
    }

}
