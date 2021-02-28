package co.com.sofka.crud.service;

import co.com.sofka.crud.dto.InterfazDTO;
import co.com.sofka.crud.model.Category;
import co.com.sofka.crud.repository.CategoryRepository;
import co.com.sofka.crud.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TodoRepository todoRepository;

    public Iterable<Category> list(){
        return categoryRepository.findAll();
    }

    public Category save(@Valid Category category){
        return categoryRepository.save(category);
    }

    public void delete(Long id){
        categoryRepository.delete(get(id));
    }

    public Category get(Long id){
        return categoryRepository.findById(id).orElseThrow();
    }

    public InterfazDTO listInterfaz(){

        InterfazDTO interfazDTO = new InterfazDTO();

        interfazDTO.setCategories(list());
        interfazDTO.setTodos(todoRepository.findAll());

        return interfazDTO;
    }
}
