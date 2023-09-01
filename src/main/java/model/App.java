package model;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Person bassim = new Person("Bassim","Durzi","bassimdurzi@gmail.com");
        System.out.println(bassim.toString());

        TodoItem task1 = new TodoItem("Change tires","need help from Ali", LocalDate.of(2023,11,1), false, bassim);

        System.out.println(task1.toString());

        AppUser user1 = new AppUser("bassim","123");
        user1.setRole(AppRole.ROLE_APP_ADMIN);
        System.out.println(user1.toString());
    }
}
