package com.example.security_demo.repository;

import com.example.security_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<User, String> {

}
