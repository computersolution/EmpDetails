package com.org.employee.service;

import java.util.List;


import com.org.employee.bean.Employee;
import com.org.employee.bean.Filter;
import com.org.employee.exception.EmployeeException;


/**
*  The EmployeeService is service interface is used to
*  creates the services for create,update,delete,get
*  list of an employee and filter an employee.
*  
* 
* @author  Dillibabu T
* @version 1.0
* @since   13-01-2019
*/
public interface EmployeeService {
	
	public void createEmployee(List<Employee> employeeList) throws EmployeeException;
	public void updateEmployee(List<Employee> employeeList) throws EmployeeException;
	public void deleteEmployee(List<Employee> employeeList) throws EmployeeException;
	public List<Employee> getEmployeeList() throws EmployeeException;
	public List<Employee> getEmployeeFilter(Filter filter) throws EmployeeException;
	
	
	
	
	
	

}
