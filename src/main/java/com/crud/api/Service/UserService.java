package com.crud.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;

import com.crud.api.Entity.Role;
import com.crud.api.Entity.User;
import com.crud.api.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;

    public User create(User user) {
        Role role = roleService.findByName(user.getRole().getName());
        user.setUsername(user.getUsername());
        user.setEmail(user.getEmail());
        user.setPassword(DigestUtils.sha256Hex(user.getPassword()));
        user.setRole(role);

        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User update(User user) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        return userRepository.save(existingUser);
    }

    public String delete(Long id) {
        userRepository.deleteById(id);
        return "User ID " + id + " has been removed";
    }

    public boolean verifyPassword(User user, String password) {
        String hashedPassword = user.getPassword();
        return hashedPassword.equals(DigestUtils.sha256Hex(password));
    }
}