package com.kruger.employeevaccination.commons.response;

import java.io.Serializable;

import com.kruger.employeevaccination.entities.Employee;

import lombok.Data;

@Data
public class EmployeePostRes  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Employee employee;
}
