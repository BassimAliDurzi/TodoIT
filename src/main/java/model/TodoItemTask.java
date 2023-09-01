package model;

public class TodoItemTask {
    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;


    public int id() {
        return id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        if (assignee != null); this.assigned = true;
    }

    public TodoItem todoItem() {
        return todoItem;
    }

    public void setTodoItem(TodoItem todoItem) {
        if (todoItem == null) throw new IllegalArgumentException();
        this.todoItem = todoItem;
    }

    public Person assignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }

    @Override
    public String toString() {
        return "TodoItemTask{" +
                "id: " + id +
                ", assigned: " + assigned +
                ", todoItem: " + todoItem +
                ", assignee: " + assignee +
                '}';
    }
}
