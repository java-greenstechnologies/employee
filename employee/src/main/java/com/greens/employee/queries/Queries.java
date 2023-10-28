package com.greens.employee.queries;

public class Queries {

	public static String INSERT_EMP_DATA = "INSERT INTO employee_details (emp_id, first_name, last_name, age, gender, location, email, phone) "
			+ "VALUES (:EMP_ID, :FIRST_NAME, :LAST_NAME, :AGE, :GENDER, :LOCATION, :EMAIL, :PHONE)";


	public static String UPDATE_EMP_DATA = "UPDATE employee_details SET first_name = :FIRST_NAME, last_name = :LAST_NAME, age = :AGE, gender = :GENDER, location = :LOCATION, email = :EMAIL, phone = :PHONE WHERE emp_id = :EMP_ID";

	public static String DELETE_ALL_EMP_DATA = "DELETE FROM employee_details";
	
	public static String DELETE_EMP_BY_ID = "DELETE FROM employee_details WHERE emp_id = :EMP_ID";

	public static String GET_ALL_EMP = "SELECT * FROM employee_details";
	
	public static String GET_EMP_BY_ID = "SELECT * FROM employee_details WHERE emp_id = :EMP_ID";

}
