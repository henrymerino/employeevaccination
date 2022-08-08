package com.kruger.employeevaccination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kruger.employeevaccination.entities.Users;
public interface UserRepo extends JpaRepository<Users, Long>{
	
 com.kruger.employeevaccination.entities.Users findByUsername(String username);

}
