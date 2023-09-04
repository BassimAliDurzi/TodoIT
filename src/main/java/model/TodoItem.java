package model;

import dao.TodoItemDAO;
import sequencers.TodoItemIdSequencer;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;

public class TodoItem extends TodoItemIdSequencer implements TodoItemDAO {
    private int id;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;
    HashSet<TodoItem> todoItems = new HashSet<>();

    public TodoItem(String title, String taskDescription, LocalDate deadLine, boolean done, Person creator) {
        this.setTitle(title);
        this.taskDescription = taskDescription;
        this.setDeadLine(deadLine);
        this.done = done;
        this.creator = creator;
    }

    public TodoItem(int id) {
        super();
    }

    public TodoItem(boolean done) {
        super();
    }

    public TodoItem(String title) {
        super();
    }

    public TodoItem(LocalDate date) {
        super();
    }

    public int id() {
        return id;
    }

    public String title() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null) throw new IllegalArgumentException("Not allowed to be null or empty");
        this.title = title;
    }

    public String taskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate deadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        if (deadLine == null) throw new IllegalArgumentException("Not allowed to be null");
        this.deadLine = deadLine;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Person creator() {
        return creator;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    public boolean isOverdue() {
        if (LocalDate.now().isAfter(deadLine)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "ID: " + nextId() +
                ", Title: '" + title + '\'' +
                ", Task Description: '" + taskDescription + '\'' +
                ", Dead Line: " + deadLine +
                ", Done: " + done +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoItem todoItem)) return false;
        return id == todoItem.id && isDone() == todoItem.isDone() && Objects.equals(title, todoItem.title) && Objects.equals(taskDescription, todoItem.taskDescription) && Objects.equals(deadLine, todoItem.deadLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, taskDescription, deadLine);
    }

    @Override
    public void persist(TodoItem todoItem) {
        todoItems.add(todoItem);
    }

    @Override
    public TodoItem findById(int id) {
        TodoItem searchedTodoItem = new TodoItem(id);
        for (TodoItem todoItem : todoItems) {
            if (todoItem.id == searchedTodoItem.id) {
                System.out.println(todoItem);
            }
        }
        return searchedTodoItem;
    }

    @Override
    public void findAll(HashSet<TodoItem> todoItems) {
        for (TodoItem todoItem : todoItems) {
            System.out.println(todoItem);
        }

    }

    @Override
    public void findByDoneStatus(boolean done) {
        TodoItem todoItemDoneStatus = new TodoItem(done);
        for (TodoItem todoItem : todoItems) {
            if (todoItem.done == todoItemDoneStatus.done) {
                System.out.println(todoItem);
            }
        }
    }

    @Override
    public void findByTitleContains(String title) {
        TodoItem todoItemContains = new TodoItem(title);
        for (TodoItem todoItem : todoItems) {
            if (todoItem.title.contains((CharSequence) todoItemContains)) {
                System.out.println(todoItem);
            }
        }
    }

    @Override
    public TodoItem findByPersonId(int id) {
        TodoItem personId = new TodoItem(id);
        for (TodoItem todoItem : todoItems) {
            if (creator().id() == personId.id) {
                System.out.println(todoItem);
            }
        }
        return personId;

    }

    @Override
    public void findByDeadlineBefore(LocalDate date) {
        TodoItem deadlineBefore = new TodoItem(date);
        for (TodoItem todoItem : todoItems) {
            if (deadlineBefore.deadLine.isBefore(todoItem.deadLine)) {
                System.out.println(todoItem);
            }
        }
    }

    @Override
    public void findByDeadlineAfter(LocalDate date) {
        TodoItem deadlineBefore = new TodoItem(date);
        for (TodoItem todoItem : todoItems) {
            if (deadlineBefore.deadLine.isAfter(todoItem.deadLine)) {
                System.out.println(todoItem);
            }
        }

    }

    @Override
    public void remove() {
        todoItems.remove(findById(id));
    }
}


