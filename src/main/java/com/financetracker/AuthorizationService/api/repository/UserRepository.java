package com.financetracker.AuthorizationService.api.repository;


import com.financetracker.AuthorizationService.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
