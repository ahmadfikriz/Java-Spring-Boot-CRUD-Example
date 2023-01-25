package com.crud.api.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.api.Entity.Role;
import com.crud.api.Repository.RoleRepository;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role create(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    public Role update(Role role) {
        return roleRepository.save(role);
    }

    public String delete(Long id) {
        roleRepository.deleteById(id);
        return "Role ID " + id + " has been removed";
    }

    // public Role findByName(String name) {
    //     return roleRepository.findByName(name);
    // }

    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
