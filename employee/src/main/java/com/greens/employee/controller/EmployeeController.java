package com.greens.employee.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greens.employee.model.Employee;
import com.greens.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee/api/v1/")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@PostMapping("/")
	public void saveEmployeeData(@RequestBody Employee employee) {
		employeeService.saveEmployeeData(employee);
	}
	
	@PutMapping("/")
	public void updateEmployeeData(@RequestBody Employee employee) {
		employeeService.updateEmployeeData(employee);
	}
	
	@DeleteMapping("/")
	public void deleteAllRecords() {
		employeeService.deleteAllRecords();
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmpDataById(@PathVariable("id") Long empId) {
		employeeService.deleteEmpDataById(empId);
	}
	
	@GetMapping("/")
	public List<Map<String, Object>> getAllRecords() {
		List<Map<String, Object>> empData = employeeService.getAllRecords();
		return empData;
	}
	
	@GetMapping("/{id}")
	public List<Map<String, Object>> getEmpDataById(@PathVariable("id") Long empId) {
		List<Map<String, Object>> empData = employeeService.getEmpDataById(empId);
		return empData;
	}
}



