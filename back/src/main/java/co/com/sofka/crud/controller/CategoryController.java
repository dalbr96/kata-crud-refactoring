package co.com.sofka.crud.controller;

import co.com.sofka.crud.service.CategoryService;
import co.com.sofka.crud.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

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
    public Category save(@Valid @RequestBody Category category){
        return categoryService.save(category);
    }

    @PutMapping("api/category")
    public Category update(@Valid @RequestBody Category category){
        if(category.getId() != null){
            return categoryService.save(category);
        }
        throw new RuntimeException("There is not id to update");
    }

    @DeleteMapping("api/{id}/category")
    public void delete(@PathVariable Long id){
        categoryService.delete(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return errors;
    }
}