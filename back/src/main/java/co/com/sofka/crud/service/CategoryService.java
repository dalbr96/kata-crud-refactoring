package co.com.sofka.crud.service;

import co.com.sofka.crud.model.Category;
import co.com.sofka.crud.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

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
}
