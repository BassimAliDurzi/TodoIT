package dao;

import model.TodoItem;

import java.time.LocalDate;
import java.util.HashSet;

public interface TodoItemDAO {
    void persist(TodoItem todoItem);
    TodoItem findById(int id);
    void findAll(HashSet<TodoItem> todoItems);
    void findByDoneStatus(boolean done);
    void findByTitleContains(String title);
    TodoItem findByPersonId(int id);
    void findByDeadlineBefore(LocalDate date);
    void findByDeadlineAfter(LocalDate date);
    void remove();


}
