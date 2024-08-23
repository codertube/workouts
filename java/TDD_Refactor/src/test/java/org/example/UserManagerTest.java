package org.example;

import org.example.exceptions.UserException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {
    public static final String USER_NAME = "John";
    public static final String USER_NAME2 = "John";
    public static final String INVALID_USER_NAME = "";
    public static final String INVALID_USER_NAME2 = "";
    public static final int AGE = 25;
    public static final int INVALID_AGE = -2;
    private List<User> users;
    private User user;
    private UserManager userManager;

    @Before
    public void setUp() throws Exception {
        users = new ArrayList<>();
        userManager = new UserManager(users);
        user = new User(USER_NAME, AGE);
    }

    @Test
    public void addUserTest() {

        userManager.addUser(user);
        assertEquals(1, users.size());
    }

    @Test
    public void addInvalidUserTest() {

        userManager.addUser(user);
        assertThrows(UserException.class, () ->  userManager.addUser(new User(USER_NAME, AGE)));
    }

    @Test
    public void getUserTest() {

        userManager.addUser(user);
        User user1 = userManager.getUser(USER_NAME);
        assertNotNull(user1);

    }

    @Test
    public void getUserTest2() {

        userManager.addUser(user);
        User user1 = userManager.getUser("Tom");
        assertNull(user1);

    }

    @Test
    public void removeUserTest() {

        userManager.addUser(user);
        userManager.removeUser(USER_NAME);
        assertTrue(users.isEmpty());

    }
}