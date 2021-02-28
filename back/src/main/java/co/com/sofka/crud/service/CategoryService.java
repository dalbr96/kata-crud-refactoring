package co.com.sofka.crud.service;

import co.com.sofka.crud.assembler.Assembler;
import co.com.sofka.crud.dto.CategoryDTO;
import co.com.sofka.crud.dto.InterfazDTO;
import co.com.sofka.crud.dto.TodoDTO;
import co.com.sofka.crud.model.Category;
import co.com.sofka.crud.model.Todo;
import co.com.sofka.crud.repository.CategoryRepository;
import co.com.sofka.crud.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TodoRepository todoRepository;

    public Iterable<CategoryDTO> list(){

        List<CategoryDTO> categoriesDTO = new ArrayList<>();

        Iterable<Category> categories = categoryRepository.findAll();

        for(Category category: categories){
            categoriesDTO.add(Assembler.makeCategoryDTO(category));
        }

        return categoriesDTO;
    }

    public CategoryDTO save(@Valid CategoryDTO categoryDTO){
        Category category = Assembler.makeCategory(categoryDTO);

        Category newCategory = categoryRepository.save(category);

        CategoryDTO newCategoryDTO = Assembler.makeCategoryDTO(newCategory);

        return newCategoryDTO;
    }

    public void delete(Long id){
        Category category = Assembler.makeCategory(get(id));
        categoryRepository.delete(category);
    }

    public CategoryDTO get(Long id){

        CategoryDTO categoryDTO = new CategoryDTO();

        Category category = categoryRepository.findById(id).orElseThrow();

        categoryDTO = Assembler.makeCategoryDTO(category);

        return categoryDTO;
    }

    public InterfazDTO listInterfaz(){

        InterfazDTO interfazDTO = new InterfazDTO();

        interfazDTO.setCategories(list());

        Iterable<Todo> todos = todoRepository.findAll();
        List<TodoDTO> todosDTO = new ArrayList<>();

        for(Todo todo: todos){
            todosDTO.add(Assembler.makeTodoDTO(todo));
        }
        interfazDTO.setTodos(todosDTO);

        return interfazDTO;
    }
}
