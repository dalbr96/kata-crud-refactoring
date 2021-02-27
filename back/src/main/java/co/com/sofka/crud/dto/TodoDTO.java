package co.com.sofka.crud.dto;


public class TodoDTO {


    private Long todoID;
    private String todoName;
    private boolean todoCompleted;


    private Long categoryId;
    private String categoryName;

    public Long getTodoID() {
        return todoID;
    }

    public void setTodoID(Long todoID) {
        this.todoID = todoID;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public boolean isTodoCompleted() {
        return todoCompleted;
    }

    public void setTodoCompleted(boolean todoCompleted) {
        this.todoCompleted = todoCompleted;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
