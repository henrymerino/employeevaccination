package com.kruger.employeevaccination;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.kruger.employeevaccination.entities.Catalogue;
import com.kruger.employeevaccination.entities.CatalogueDetail;
import com.kruger.employeevaccination.entities.Role;
import com.kruger.employeevaccination.entities.Users;
import com.kruger.employeevaccination.service.CatalogueService;
import com.kruger.employeevaccination.service.CataloguesService;
import com.kruger.employeevaccination.service.UserService;

@SpringBootApplication
public class EmployeevaccinationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeevaccinationApplication.class, args);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	} 
	
	@Bean
	CommandLineRunner run(UserService userService,CatalogueService catalogueService,CataloguesService cataloguesService) {
		return args -> {
			userService.saveRole(new Role(null,"ROLE_EMPLOYEE"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			
			userService.saveUser(new Users(null, "John Travoltar", "john", "1234", new ArrayList<>()));
			userService.saveUser(new Users(null, "Will Smith", "will", "1234", new ArrayList<>()));
			userService.saveUser(new Users(null, "Jim Carry", "jim", "1234", new ArrayList<>()));
			userService.saveUser(new Users(null, "Arnold Schwarzenegger", "arnold", "1234", new ArrayList<>()));
			
			userService.addRoleToUser("john", "ROLE_EMPLOYEE");
			userService.addRoleToUser("john", "ROLE_ADMIN");
			userService.addRoleToUser("will", "ROLE_ADMIN");
			userService.addRoleToUser("jim", "ROLE_ADMIN");
			userService.addRoleToUser("arnold", "ROLE_EMPLOYEE");
			userService.addRoleToUser("arnold", "ROLE_ADMIN");
			userService.addRoleToUser("arnold", "ROLE_EMPLOYEE");
			
			catalogueService.save(new Catalogue(1,"status","status", "status", Boolean.TRUE, new ArrayList<>()));
			catalogueService.save(new Catalogue(2,"vaccines","Vaccines", "Vaccines", Boolean.TRUE, new ArrayList<>()));
			
			cataloguesService.save(new CatalogueDetail(1,"active","active", "Active", Boolean.TRUE,catalogueService.getCatalogue("status").get(0)));
			cataloguesService.save(new CatalogueDetail(2,"deactivate","deactivate", "Deactivate", Boolean.TRUE,catalogueService.getCatalogue("status").get(0)));
			cataloguesService.save(new CatalogueDetail(3,"sputnik","Sputnik", "Sputnik", Boolean.TRUE,catalogueService.getCatalogue("vaccines").get(0)));
			cataloguesService.save(new CatalogueDetail(4,"astraZeneca","AstraZeneca", "AstraZeneca", Boolean.TRUE, catalogueService.getCatalogue("vaccines").get(0)));
			cataloguesService.save(new CatalogueDetail(5,"pfizer","Pfizer", "Pfizer", Boolean.TRUE, catalogueService.getCatalogue("vaccines").get(0)));
			cataloguesService.save(new CatalogueDetail(6,"jhonson","Jhonson&Jhonson", "Jhonson&Jhonson", Boolean.TRUE,catalogueService.getCatalogue("vaccines").get(0)));
			
			
		};
	}

}
