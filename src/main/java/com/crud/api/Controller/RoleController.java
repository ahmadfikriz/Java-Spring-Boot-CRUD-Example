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
    public Role createRole(@RequestBody Role role) {
        return roleService.create(role);
    }

    @GetMapping("roles")
    public List<Role> getAllRoles() {
        return roleService.findAll();
    }

    @PutMapping("role{id}")
    public Role updateRole(@PathVariable Long id, @RequestBody Role role) {
        role.setId(id);
        return roleService.update(role);
    }

    @DeleteMapping("role{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteById(id);
    }
}
