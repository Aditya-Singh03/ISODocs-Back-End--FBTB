package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.User;
import com.example.Model.loginRequest;
import com.example.Model.loginReturn;

@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private final UserRepository userRepository;
 
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/logIn")
    public ResponseEntity<loginReturn> logIn(@RequestBody loginRequest login) {
        User user = userRepository.findByName(login.username);

        if (user != null && user.getPassword().equals(login.password)) {
            return ResponseEntity.ok(new loginReturn(true, "Log-in successful"));
        } else {
            return ResponseEntity.ok(new loginReturn(false, "Log-in failed"));
        }
    }
}
