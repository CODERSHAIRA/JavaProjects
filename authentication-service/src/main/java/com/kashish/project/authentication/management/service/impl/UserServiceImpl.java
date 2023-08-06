package com.kashish.project.authentication.management.service.impl;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kashish.project.authentication.management.model.RoleEntity;
import com.kashish.project.authentication.management.model.UserEntity;
import com.kashish.project.authentication.management.model.UserInfo;
import com.kashish.project.authentication.management.repository.RoleRepository;
import com.kashish.project.authentication.management.repository.UserRepository;
import com.kashish.project.authentication.management.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

	private final UserRepository userRepository;

	private final RoleRepository roleRepository;

	@Override
	public void registerUser(UserInfo user) {

		if (userRepository.findByUsername(user.getUsername()) != null) {
			throw new RuntimeException("Username already exists");
		}

		if (userRepository.findByEmail(user.getEmail()) != null) {
			throw new RuntimeException("Email already exists");
		}

		UserEntity userEntity = new UserEntity();
		userEntity.setUsername(user.getUsername());
		userEntity.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		userEntity.setEmail(user.getEmail());

		RoleEntity role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
        	RoleEntity roleEntity = new RoleEntity();
    		roleEntity.setName("ROLE_ADMIN");
    		role = roleRepository.save(roleEntity);
        }
        
		
		
		userEntity.setRoles(Arrays.asList(role));
		userRepository.save(userEntity);

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(),
            new ArrayList<>()
        );
	}
	
	

}
