package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Employee;

public interface EmployeeServiceInterface {

	public Employee addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(Long id);

	public void deleteEmployeeById(Long id);

}
