package com.gpch.login.repository;

import com.gpch.login.model.login.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

//@Repository("userRepository")
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
    Users findById(int id);
    Users findByInitials(String initials);
}