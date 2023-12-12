package com.example.demo;


import com.example.Model.User;
import com.example.Model.loginRequest;
import com.example.Model.loginReturn;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


@SpringBootTest
public class LoginTests {


    private final UserRepository userRepository;
    private final LoginController loginController;


    @Autowired
    public LoginTests(UserRepository userRepository, LoginController loginController) {
        this.userRepository = userRepository;
        this.loginController = loginController;
    }


    @Test
    public void testGetEmptyUsernameAndPassword() {
        loginRequest loginRequest = new loginRequest("", "");
        assertEquals("", loginRequest.getUsername(), "Username is empty");
        assertEquals("", loginRequest.getPassword(), "Password is empty");
    }


    @Test
    public void testSetUsernameAndPassword() {
        loginRequest loginRequest = new loginRequest("", "");
        loginRequest.setUserame("user1");
        loginRequest.setPassword("password123");
        assertEquals("user1", loginRequest.getUsername(), "Username is empty");
        assertEquals("password123", loginRequest.getPassword(), "Password is empty");
    }


    @Test
    public void testOnlyUsername() {
        loginRequest loginRequest = new loginRequest("user1", "");
        User user = userRepository.findByName(loginRequest.getUsername());
        assertEquals(loginRequest.getUsername(), user.getName(), "Username is in the database");
    }


    @Test
    public void testOnlyInvalidUsername() {
        loginRequest loginRequest = new loginRequest("Paul McCartney", "");
        User user = userRepository.findByName(loginRequest.getUsername());
        assertEquals(null, user, "Username is not in the database, maybe try Ringo Starr next time");
    }
   


    @Test
    public void testInvalidLogin() {
        loginRequest loginRequest = new loginRequest("user1", "samplePassword"); // correct username but wrong password
        assertNotEquals(userRepository.existsByNameAndPassword(loginRequest.getUsername(), loginRequest.getPassword()), true);
    }


    @Test
    public void testValidLogin() {
        loginRequest loginRequest = new loginRequest("user1", "password123");
        assertEquals(userRepository.existsByNameAndPassword(loginRequest.getUsername(), loginRequest.getPassword()), true);
    }
 }



