package com.org.employee.fao;

import java.util.List;

import com.org.employee.bean.Employee;
import com.org.employee.exception.EmployeeException;

/**
*  The EmployeeFAO interface is used to
*  creates the services for file accessing
*  objects.
*  
* 
* @author  Dillibabu T
* @version 1.0
* @since   13-01-2019
*/
public interface EmployeeFAO {
	public List<Employee> getEmployeeList() throws EmployeeException;
	public void createEmployeeList(List<Employee> createEmployeeList) throws EmployeeException;
	public void updateEmployeeList(List<Employee> updateEmployeeList) throws EmployeeException;
	public void deleteEmployeeList(List<Employee> deleteEmployeeList) throws EmployeeException;
}