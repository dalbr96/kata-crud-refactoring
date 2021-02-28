package co.com.sofka.crud.controller;

import co.com.sofka.crud.dto.CategoryDTO;
import co.com.sofka.crud.dto.InterfazDTO;
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
    public Iterable<CategoryDTO> list(){
        return categoryService.list();
    }

    @GetMapping("api/{id}/category")
    public CategoryDTO get(@PathVariable Long id){
        return categoryService.get(id);
    }

    @PostMapping("api/category")
    public CategoryDTO save(@Valid @RequestBody CategoryDTO categoryDTO){
        return categoryService.save(categoryDTO);
    }

    @PutMapping("api/category")
    public CategoryDTO update(@Valid @RequestBody CategoryDTO categoryDTO){
        if(categoryDTO.getId() != null){
            return categoryService.save(categoryDTO);
        }
        throw new RuntimeException("There is not id to update");
    }

    @DeleteMapping("api/{id}/category")
    public void delete(@PathVariable Long id){
        categoryService.delete(id);
    }

    @GetMapping("api/show-interfaz")
    public InterfazDTO listInterfaz(){
        return categoryService.listInterfaz();
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