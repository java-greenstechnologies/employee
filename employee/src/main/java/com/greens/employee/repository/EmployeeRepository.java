package com.greens.employee.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.greens.employee.model.Employee;
import com.greens.employee.queries.Queries;

@Repository
public class EmployeeRepository {
	
	@Autowired
	NamedParameterJdbcTemplate npJdbcTmpl;

	public void saveEmployeeData(Employee employee) {
		String insertQuery = Queries.INSERT_EMP_DATA;
		Map<String, Object> inData = new HashMap<>();
		inData.put("EMP_ID", employee.getEmpId());
		inData.put("FIRST_NAME", employee.getFirstName());
		inData.put("LAST_NAME", employee.getLastName());
		inData.put("AGE", employee.getAge());
		inData.put("GENDER", employee.getGender());
		inData.put("LOCATION", employee.getLocation());
		inData.put("EMAIL", employee.getEmail());
		inData.put("PHONE", employee.getPhone());
		npJdbcTmpl.update(insertQuery, inData);
	}
	
	public void updateEmployeeData(Employee employee) {
		String updateQuery = Queries.UPDATE_EMP_DATA;
		Map<String, Object> inData = new HashMap<>();
		inData.put("EMP_ID", employee.getEmpId());
		inData.put("FIRST_NAME", employee.getFirstName());
		inData.put("LAST_NAME", employee.getLastName());
		inData.put("AGE", employee.getAge());
		inData.put("GENDER", employee.getGender());
		inData.put("LOCATION", employee.getLocation());
		inData.put("EMAIL", employee.getEmail());
		inData.put("PHONE", employee.getPhone());
		npJdbcTmpl.update(updateQuery, inData);
	}
	
	public void deleteAllRecords() {
		String deleteAllEmpQuery = Queries.DELETE_ALL_EMP_DATA;
		Map<String, Object> inData = new HashMap<>();
		npJdbcTmpl.update(deleteAllEmpQuery, inData);
	}
	
	
	public void deleteEmpDataById(Long empId) {
		String deleteEmpById = Queries.DELETE_EMP_BY_ID;
		Map<String, Object> inData = new HashMap<>();
		inData.put("EMP_ID", empId);
		npJdbcTmpl.update(deleteEmpById, inData);
	}
	
	public List<Map<String, Object>> getAllRecords() { 
		String getAllEmp = Queries.GET_ALL_EMP;
		Map<String, Object> inData = new HashMap<>();
		List<Map<String, Object>> empData = npJdbcTmpl.queryForList(getAllEmp, inData);
		return empData;
	}
	
	public List<Map<String, Object>> getEmpDataById(Long empId) {
		String getEmpDataById = Queries.GET_EMP_BY_ID;
		Map<String, Object> inData = new HashMap<>();
		inData.put("EMP_ID", empId);
		List<Map<String, Object>> empDataById = npJdbcTmpl.query(getEmpDataById, inData, (rs) -> {
			List<Map<String, Object>> empData = new ArrayList<>();
			while(rs.next()) {
				Map<String, Object> data = new HashMap<>();
				data.put("empId", rs.getLong("emp_id"));
				data.put("firstName", rs.getString("first_name"));
				data.put("lastName", rs.getString("last_name"));
				data.put("age", rs.getInt("age"));
				data.put("gender", rs.getString("gender"));
				data.put("location", rs.getString("location"));
				data.put("email", rs.getString("email"));
				data.put("phone", rs.getLong("phone"));
				empData.add(data);
			}
			return empData;
		});
		return empDataById;
	}
}







