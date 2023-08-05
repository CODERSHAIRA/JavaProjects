package com.kashish.project.authentication.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kashish.project.authentication.management.model.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

}
