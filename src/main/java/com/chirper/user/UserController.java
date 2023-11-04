package com.chirper.user;

import com.chirper.exception.WrongEmailException;
import com.chirper.exception.WrongPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String hello() {
        return "Hello";
    }

    @PostMapping("/user/register")
    public User register(@RequestBody User user) {

        return userRepository.save(user);
    }

    @PostMapping("/user/login")
    public Integer login(@RequestBody User user) {

        User existingUser = userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new WrongEmailException("No such user with email: " + user.getEmail()));

        if(!existingUser.getPassword().equals(user.getPassword()))
            throw new WrongPasswordException("Wrong password");

        return existingUser.getId();
    }
}
