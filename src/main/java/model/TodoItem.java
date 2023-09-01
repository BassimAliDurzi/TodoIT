package model;

import java.time.LocalDate;

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
    public String getSummary() {
        return "ID: " + id +
               ", Title: " + title +
               ", Description: " + taskDescription +
               ", Deadline: " + deadLine +
               ", Done: " + isDone() +
               ", Creator: " + creator.firstName() + " " + creator.lastName();
    }
}


