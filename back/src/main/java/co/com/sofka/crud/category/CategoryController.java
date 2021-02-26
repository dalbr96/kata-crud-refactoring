package co.com.sofka.crud.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @GetMapping("api/categories")
    public Iterable<Category> list(){
        return categoryService.list();
    }

    @GetMapping("api/{id}/category")
    public Category get(@PathVariable Long id){
        return categoryService.get(id);
    }

    @PostMapping("api/category")
    public Category save(Category category){
        return categoryService.save(category);
    }

    @PutMapping("api/category")
    public Category update(@RequestBody Category category){
        if(category.getId() != null){
            return categoryService.save(category);
        }
        throw new RuntimeException("There is not id to update");
    }

    @DeleteMapping("api/{id}/category")
    public void delete(@PathVariable Long id){
        categoryService.delete(id);
    }
}