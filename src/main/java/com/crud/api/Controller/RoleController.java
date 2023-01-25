package com.crud.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.crud.api.Entity.Role;
import com.crud.api.Service.RoleService;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("create")
    public Role create(@RequestBody Role role) {
        return roleService.create(role);
    }

    @GetMapping("roles")
    public List<Role> findAll() {
        return roleService.findAll();
    }

    @GetMapping("role/{id}")
    public Role findRoleById(@PathVariable Long id) {
        return roleService.findById(id);
    }

    @PutMapping("role/update/{id}")
    public Role update(@PathVariable Long id, @RequestBody Role role) {
        role.setId(id);
        return roleService.update(role);
    }

    @DeleteMapping("role/delete/{id}")
    public String delete(@PathVariable Long id) {
        return roleService.delete(id);
    }
}
