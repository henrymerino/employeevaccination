package com.kruger.employeevaccination.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kruger.employeevaccination.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Long>{
	 com.kruger.employeevaccination.entities.Role findByname(String name);
}
