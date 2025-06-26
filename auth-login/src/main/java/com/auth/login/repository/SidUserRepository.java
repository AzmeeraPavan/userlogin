package com.auth.login.repository;

import com.auth.login.model.SidUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SidUserRepository extends JpaRepository<SidUser, Long> {

    // Find user by email
    SidUser findByEmail(String email);

    // Check if email already exists (for signup validation)
    boolean existsByEmail(String email);

    // Find user by email and password (for login)
    SidUser findByEmailAndPassword(String email, String password);
}
