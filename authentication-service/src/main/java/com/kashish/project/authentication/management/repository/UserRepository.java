package com.kashish.project.authentication.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kashish.project.authentication.management.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	UserEntity findByUsername(String username);

	UserEntity findByEmail(String email);

}
