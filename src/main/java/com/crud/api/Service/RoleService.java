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

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role create(Role role) {
        return roleRepository.save(role);
    }

    public Role update(Role role) {
        return roleRepository.save(role);
    }

    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }

    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
