package dao;

import model.AppUser;

import java.util.HashSet;

public interface AppUserDAO {

    void persist(AppUser appUser);

    AppUser findByUserName(String userName);

    void findAll(HashSet<AppUser> appUsers);

    void remove();

}
