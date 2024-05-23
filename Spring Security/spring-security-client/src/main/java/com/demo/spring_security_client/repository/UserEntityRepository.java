package com.demo.spring_security_client.repository;

import com.demo.spring_security_client.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {
}
