package com.crud.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.api.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

    Role findByName(Role role);
    
}
