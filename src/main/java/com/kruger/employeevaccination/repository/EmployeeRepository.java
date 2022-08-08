package com.kruger.employeevaccination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kruger.employeevaccination.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByIdEmployee(Integer id);
    
    @Query(value = "SELECT * FROM Employee e WHERE e.identification = :identification", nativeQuery = true)
    Employee findByIdentificationEmployee(String identification);
}
