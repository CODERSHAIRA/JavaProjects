package com.kashish.project.authentication.management.service.impl;

import org.springframework.stereotype.Service;

import com.kashish.project.authentication.management.model.RoleEntity;
import com.kashish.project.authentication.management.model.User;
import com.kashish.project.authentication.management.model.UserEntity;
import com.kashish.project.authentication.management.repository.RoleRepository;
import com.kashish.project.authentication.management.repository.UserRepository;
import com.kashish.project.authentication.management.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    
	private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Override
    public Void registerUser(User user) {
        UserEntity userEntity = new UserEntity();
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        user.setEmail(user.getEmail());
        
        userRepository.save(userEntity);
        
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName("USER");
        roleRepository.save(roleEntity);
        return null;
    }

	
}
