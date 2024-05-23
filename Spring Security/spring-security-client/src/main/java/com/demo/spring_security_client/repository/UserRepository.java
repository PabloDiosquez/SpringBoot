package com.demo.spring_security_client.repository;

import com.demo.spring_security_client.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
