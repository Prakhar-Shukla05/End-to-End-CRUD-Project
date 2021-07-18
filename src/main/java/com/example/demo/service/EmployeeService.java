package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.custom.exception.BusinessException;
import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService implements EmployeeServiceInterface {

	private final EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		

			
		if(employee.getName().isEmpty() || employee.getName().length()==0) {
				throw new BusinessException("601","Please send proper name. It's Blank");
		}
		try {
			Employee savedEmployee=employeeRepository.save(employee);
			return savedEmployee;
			}
		catch(IllegalArgumentException e) {
			throw new BusinessException("602","Given employee is null "+ e.getMessage());
		}
		catch(Exception e) {
			throw new BusinessException("603","Something went wrong in Service Layer while saving the employee "+ e.getMessage());
		}
		
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> empList=null;
		try {
			 empList = employeeRepository.findAll();
		}
		catch (Exception e) {
			throw new BusinessException("605", "Something happened in service layer while fetching all the employees");
		}
		if (empList.isEmpty())
				throw new BusinessException("604", "Here list is completely empty. There is nothing to return");

        return empList;
		 
	}

	@Override
	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub

		try {
			Optional<Employee> employeeOptional = employeeRepository.findById(id);
			return employeeOptional.get();

		} catch (IllegalArgumentException e) {
			throw new BusinessException("602", "Given employee id is null. Please send some id " + e.getMessage());
		} catch (NoSuchElementException e) {
			throw new BusinessException("606", "given employee id is not present in the database " + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("607",
					"Something happened in service layer while fetching the employee by it's Id");
		}
	}

	@Override
	public void deleteEmployeeById(Long id) {
		// TODO Auto-generated method stub
		try {
			employeeRepository.deleteById(id);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("602", "Given employee id is null. Please send some id " + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("608", "Something happened in service layer while deleting the employee");
		}

	}

}
