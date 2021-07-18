package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.custom.exception.BusinessException;
import com.example.demo.custom.exception.ControllerException;
import com.example.demo.domain.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceInterface;

import lombok.AllArgsConstructor;

import java.util.List;

import javax.sound.midi.ControllerEventListener;


@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {
	
	private final EmployeeServiceInterface employeeServiceInterface;
	

	@PostMapping("/save")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
		try {
		Employee employeeSaved=employeeServiceInterface.addEmployee(employee);
		return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
		}
		catch(BusinessException e) {
			ControllerException ce= new ControllerException(e.getErrorCode(), e.getErrorMessge());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			ControllerException ce= new ControllerException("609", "Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("get/emp/all")
	public ResponseEntity<?> getAllEmployees(){
		try {
		System.out.println("Getting all the employees");
		List<Employee> savedList=employeeServiceInterface.getAllEmployees();
		
		return new ResponseEntity<List<Employee>>(savedList,HttpStatus.OK);
		}
		catch(BusinessException e) {
			ControllerException ce= new ControllerException(e.getErrorCode(), e.getErrorMessge());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			ControllerException ce= new ControllerException("609", "Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("get/emp/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Long id){
		try {
		Employee retrievedEmployee = employeeServiceInterface.getEmployeeById(id);
		return new ResponseEntity<Employee>(retrievedEmployee,HttpStatus.OK);
		}
		catch(BusinessException e) {
			ControllerException ce= new ControllerException(e.getErrorCode(), e.getErrorMessge());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			ControllerException ce= new ControllerException("609", "Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("delete/emp/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable Long id){
		try {
		employeeServiceInterface.deleteEmployeeById(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}

		catch(BusinessException e) {
			ControllerException ce= new ControllerException(e.getErrorCode(), e.getErrorMessge());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			ControllerException ce= new ControllerException("609", "Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
	} 
	@PutMapping("/update")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee){
		try {
		Employee employeeSaved=employeeServiceInterface.addEmployee(employee);
		return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
		}
		catch(BusinessException e) {
			ControllerException ce= new ControllerException(e.getErrorCode(), e.getErrorMessge());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			ControllerException ce= new ControllerException("609", "Something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/user")
	public String getUserMessage() {
		return "Welcome User!";
	}
	
	@GetMapping("/admin")
	public String getAdminMessage() {
		return "Welcome Admin!";
	}
	
	@GetMapping("/")
	public String getCommonMessage() {
		return "Welcome Everyone!";
	}
	
}
