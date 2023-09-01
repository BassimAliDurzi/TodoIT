package model;

import java.util.Objects;

public class AppUser {
    private String userName;
    private String password;
    private AppRole role;

    public String userName() {
        return userName;
    }

    public AppUser(String userName, String password) {
        this.setUserName(userName);
        this.setPassword(password);
    }

    public void setUserName(String userName) {
        if (userName == null) throw new IllegalArgumentException("Username is not allowed to be null or empty");
        this.userName = userName;
    }

    public String password() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null) throw new IllegalArgumentException("Password is not allowed to be null or empty");
        this.password = password;
    }

    public AppRole role() {
        return role;
    }

    public void setRole(AppRole role) {
        if (role == null) throw new IllegalArgumentException("Role is not allowed to be null or empty");
        this.role = role;
    }

    @Override
    public String toString() {
        return "AppUser {" +
                "Username: '" + userName + '\'' +
                ", Role: " + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppUser appUser)) return false;
        return Objects.equals(userName, appUser.userName) && role == appUser.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, role);
    }
}
