package dao;

import model.TodoItem;
import model.TodoItemTask;

import java.time.LocalDate;
import java.util.HashSet;

public interface TodoItemTaskDAO {
    void persist(TodoItemTask todoItemTask);
    TodoItemTask findById(int id);
    void findAll(HashSet<TodoItemTask> todoItemTasks);
    void findByAssignedStatus(boolean status);
    TodoItemTask findByPersonId(int id);
    void remove();
}
