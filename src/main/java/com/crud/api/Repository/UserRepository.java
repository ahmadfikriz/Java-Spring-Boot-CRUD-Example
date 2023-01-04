package com.crud.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.api.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    
}
