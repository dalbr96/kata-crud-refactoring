package co.com.sofka.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Todo {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "You must provide a todo")
    @Pattern(regexp="[\\w\\s,.´]*$", message = "Special characters are not allowed.")
    private String name;
    private boolean completed;

    @ManyToOne()
    private Category Category;

    public Category getCategory() {
        return Category;
    }

    public void setCategory(Category category) {
        this.Category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
