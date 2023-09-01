package model;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Person bassim = new Person("Bassim","Durzi","bassimdurzi@gmail.com");
        System.out.println(bassim.getSummary());

        TodoItem task1 = new TodoItem("Change tires","need help from Ali", LocalDate.of(2023,11,1), false, bassim);
        System.out.println(task1.isOverdue());
        System.out.println(task1.getSummary());
    }
}
