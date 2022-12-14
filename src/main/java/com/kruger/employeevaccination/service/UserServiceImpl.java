package com.kruger.employeevaccination.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kruger.employeevaccination.entities.Role;
import com.kruger.employeevaccination.entities.Users;
import com.kruger.employeevaccination.repository.RoleRepo;
import com.kruger.employeevaccination.repository.UserRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService{
	
	private final UserRepo userRepo;
	private final RoleRepo roleRepo;
	private final PasswordEncoder passwordEncoder; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user = userRepo.findByUsername(username);
		
		if(user == null) {
			log.error("User not found in data base");
			throw new UsernameNotFoundException("User not found in data base");
		}else {
			log.info("User found in data base");
		}
		
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		});
		
		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), authorities);
	}
	
	@Override
	public Users saveUser(Users user) {
		log.info("Saving new user {} to the database", user.getName());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		log.info("Saving new role {} to the database", role.getName());
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		log.info("Adding role {} to the user {} ", roleName, username);
		Users user = userRepo.findByUsername(username);
		Role role = roleRepo.findByname(roleName);
		user.getRoles().add(role);
		
	}

	@Override
	public Users getUser(String username) {
		log.info("Fetching user {} ", username);
		return userRepo.findByUsername(username);
	}

	@Override
	public List<Users> getUsers() {
		log.info("Fetching all users");
		return userRepo.findAll();
	}



}
