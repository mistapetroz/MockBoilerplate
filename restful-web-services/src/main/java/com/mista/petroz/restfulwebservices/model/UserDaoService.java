package com.mista.petroz.restfulwebservices.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author mista
 */
@Component
public class UserDaoService {

    private static final List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Peter", new Date()));
        users.add(new User(2, "James", new Date()));
        users.add(new User(3, "David", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User Save(User user) {
        user.setId(users.size() + 1);
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
    
    public User Remove (int id){
        for (User user : users){
            if (user.getId() == id){
                users.remove(user);
            }
        }
        return null;
    }

    public User deleteUser(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
