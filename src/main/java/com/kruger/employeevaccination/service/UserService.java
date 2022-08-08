package com.kruger.employeevaccination.service;

import java.util.List;

import com.kruger.employeevaccination.entities.Role;
import com.kruger.employeevaccination.entities.Users;

public interface UserService {
	Users saveUser(Users user);
	Role saveRole(Role role);
	void addRoleToUser(String username, String roleName);
	Users getUser(String username);
	List<Users> getUsers();
}
