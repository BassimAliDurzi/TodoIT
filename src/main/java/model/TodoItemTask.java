package model;

import java.util.Objects;

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
                "ID: " + id +
                ", Assigned: " + assigned +
                ", TodoItem: " + todoItem +
                ", Assignee: " + assignee +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoItemTask that)) return false;
        return id == that.id && isAssigned() == that.isAssigned() && Objects.equals(todoItem, that.todoItem) && Objects.equals(assignee, that.assignee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isAssigned(), todoItem, assignee);
    }
}
