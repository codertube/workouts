package org.example;

import java.util.Comparator;

public class UserComparator implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        if (user1.getName().compareTo(user2.getName()) == 0) {
            return Integer.compare(user1.getAge(), user2.getAge());
        } else {
            return user1.getName().compareTo(user2.getName());
        }
    }
}
