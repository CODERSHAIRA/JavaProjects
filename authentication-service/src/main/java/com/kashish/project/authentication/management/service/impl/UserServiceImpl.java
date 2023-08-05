package com.kashish.project.authentication.management.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
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
    
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(User user) {
        
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username already exists");
        }

        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already exists");
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        userEntity.setEmail(user.getEmail());

        userRepository.save(userEntity);
        
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName("USER");
        roleRepository.save(roleEntity);
    
    }

	
}



