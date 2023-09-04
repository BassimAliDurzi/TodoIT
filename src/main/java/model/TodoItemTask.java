package model;

import dao.TodoItemTaskDAO;
import sequencers.TodoItemTaskIDSequencer;

import java.util.HashSet;
import java.util.Objects;

public class TodoItemTask extends TodoItemTaskIDSequencer implements TodoItemTaskDAO {
    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    HashSet<TodoItemTask> todoItemTasks = new HashSet<>();

    public TodoItemTask(int id) {
        super();
    }

    public TodoItemTask() {

    }

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
                "ID: " + nextId() +
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

    @Override
    public void persist(TodoItemTask todoItemTask) {
        todoItemTasks.add(todoItemTask);
    }

    @Override
    public TodoItemTask findById(int id) {
        TodoItemTask searchedTodoItemTask = new TodoItemTask(id);
        for (TodoItemTask todoItemTask : todoItemTasks) {
            if (todoItemTask.id == searchedTodoItemTask.id) {
                System.out.println(todoItem);
            }
        }
        return searchedTodoItemTask;
    }

    @Override
    public void findAll(HashSet<TodoItemTask> todoItemTasks) {
        for (TodoItemTask todoItemTask: todoItemTasks) {
            System.out.println(todoItemTask);
        }

    }

    @Override
    public void findByAssignedStatus(boolean status) {

    }

    @Override
    public TodoItemTask findByPersonId(int id) {
        TodoItemTask personId = new TodoItemTask(id);
        for (TodoItemTask todoItemTask : todoItemTasks) {
            if (assignee.id() == personId.id) {
                System.out.println(todoItemTask);
            }
        }
        return personId;
    }

    @Override
    public void remove() {
        todoItemTasks.remove(findById(id));
    }
}
