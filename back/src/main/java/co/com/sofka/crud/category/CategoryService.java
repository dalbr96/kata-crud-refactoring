package co.com.sofka.crud.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<Category> list(){
        return categoryRepository.findAll();
    }

    public Category save(Category category){
        return categoryRepository.save(category);
    }

    public void delete(Long id){
        categoryRepository.delete(get(id));
    }

    public Category get(Long id){
        return categoryRepository.findById(id).orElseThrow();
    }
}
