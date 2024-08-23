package org.example;

import org.example.exceptions.UserException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserManager {

    private final List<User> users;

    public UserManager(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) throws UserException {
        if (user.getName().isEmpty() || user.getAge() < 0) {
            throw new UserException("Invalid User");
        }
        if (users.stream().anyMatch(usr -> usr.getName().equals(user.getName()) && usr.getAge() == user.getAge())) {
            throw new UserException("User already exists");
        }
        users.add(user);
    }

    public User getUser(String name) {
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    public int getAverageAge() {
//        int totalAge = 0;
//        for (User user : users) {
//            totalAge += user.getAge();
//        }
        return  users.stream()
                .collect(Collectors.averagingInt(User::getAge))
                .intValue();
    }

    public void removeUser(String name) {
//        for (User user : users) {
//            if (user.getName().equals(name)) {
//                users.remove(user);
//            }
//        }
        users.removeIf(user -> user.getName().equals(name));
    }
}
