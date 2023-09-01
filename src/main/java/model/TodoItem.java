package model;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {
    private int id;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;

    public TodoItem(String title, String taskDescription, LocalDate deadLine, boolean done, Person creator) {
        this.setTitle(title);
        this.taskDescription = taskDescription;
        this.setDeadLine(deadLine);
        this.done = done;
        this.creator = creator;
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
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "ID: " + id +
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
}


