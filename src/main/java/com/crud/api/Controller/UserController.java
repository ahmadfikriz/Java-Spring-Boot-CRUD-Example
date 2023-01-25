package com.crud.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.crud.api.Entity.User;
import com.crud.api.Service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    public User register(@RequestBody User user) {
        return userService.create(user);
    }
    
    @PostMapping("login")
    public boolean login(@RequestBody User user) {
    String username = user.getUsername();
    String password = user.getPassword();
    Optional<User> optionalUser = userService.findByUsername(username);
    if (optionalUser.isPresent()) {
        User userInDatabase = optionalUser.get();
        if (userService.verifyPassword(userInDatabase, password)) {
            // simpan informasi login ke sesi atau cookie
            return true;
        } else {
            return false;
        }
    } else {
        return false;
    }
    }

    @GetMapping("users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("userid/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("username/{username}")
    public Optional<User> findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @PutMapping("user/update/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return userService.update(user);
    }

    @DeleteMapping("user/delete/{id}")
    public String delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}