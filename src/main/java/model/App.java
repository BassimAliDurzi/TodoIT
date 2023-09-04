package model;

import java.time.LocalDate;
import java.util.HashSet;

public class App {
    public static void main(String[] args) {
        Person bassim = new Person("Bassim","Durzi","bassimdurzi@gmail.com");
        System.out.println(bassim.toString());
        System.out.println("----------------------------------------------");

        Person ali = new Person("Ali","Durzi","ali@gmail.com");
        System.out.println(ali.toString());
        System.out.println("----------------------------------------------");

        TodoItem task1 = new TodoItem("Change tires","Ask Ali for help", LocalDate.of(2023,11,1), false, bassim);
        System.out.println(task1.toString());
        System.out.println("----------------------------------------------");

        TodoItem task2 = new TodoItem("Todo","todo",LocalDate.of(2023,9,15),false,bassim);
        System.out.println(task2.toString());
        System.out.println("----------------------------------------------");

        TodoItemTask itemTask1 = new TodoItemTask();
        System.out.println("itemTask1 id:" + itemTask1.nextId());

        TodoItemTask itemTask2 = new TodoItemTask();
        System.out.println("itemTask2 id:"  + itemTask2.nextId());


        System.out.println("----------------------------------------------");
        AppUser user1 = new AppUser("bassim","123");
        user1.setRole(AppRole.ROLE_APP_ADMIN);
        System.out.println(user1.toString());



    }
}
