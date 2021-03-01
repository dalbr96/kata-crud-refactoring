package co.com.sofka.crud.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class TodoDTO {

    private Long categoryId;

    @NotBlank(message = "You must provide a todo")
    @Pattern(regexp="[\\w\\s,.´]*$", message = "Special characters are not allowed.")
    private String name;

    private Long id;
    private boolean completed;


    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}