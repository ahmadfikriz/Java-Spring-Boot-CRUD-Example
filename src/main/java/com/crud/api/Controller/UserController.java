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
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
    
    @PostMapping("login")
    public boolean login(@RequestBody User user) {
    String username = user.getUsername();
    String password = user.getPassword();
    Optional<User> optionalUser = userService.getUserByName(username);
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
        return userService.getUsers();
    }

    @GetMapping("userid/{id}")
    public User findUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("username/{name}")
    public Optional<User> findUserByName(@PathVariable String username) {
        return userService.getUserByName(username);
    }

    @PutMapping("update")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}