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

    public Iterable<Todo> list(){
        return todoRepository.findAll();
    }

    public Todo save(Todo todo){
        return todoRepository.save(todo);
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
