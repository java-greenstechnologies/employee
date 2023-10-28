package com.greens.employee.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greens.employee.model.Employee;
import com.greens.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	public void saveEmployeeData(Employee employee) {
		employeeRepository.saveEmployeeData(employee);
	}
	
	public void updateEmployeeData(Employee employee) {
		employeeRepository.updateEmployeeData(employee);
	}
	
	public void deleteAllRecords() {
		employeeRepository.deleteAllRecords();
	}
	
	public void deleteEmpDataById(Long empId) {
		employeeRepository.deleteEmpDataById(empId);
	}
	
	public List<Map<String, Object>> getAllRecords() {
		List<Map<String, Object>> empData = employeeRepository.getAllRecords();
		return empData;
	}
	
	public List<Map<String, Object>> getEmpDataById(Long empId) {
		List<Map<String, Object>> empData = employeeRepository.getEmpDataById(empId);
		return empData;
	}
}
