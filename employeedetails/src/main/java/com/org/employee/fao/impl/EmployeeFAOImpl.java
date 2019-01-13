package com.org.employee.fao.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.employee.bean.Employee;
import com.org.employee.exception.EmployeeException;
import com.org.employee.fao.EmployeeFAO;
/**
*  The EmployeeFAO Implementation class is used to
*  perform an operation of create,update,delete and
*  get the details of an employee.
*  
* 
* @author  Dillibabu T
* @version 1.0
* @since   13-01-2019
*/


@Repository
@PropertySource("classpath:application.properties")
public class EmployeeFAOImpl implements EmployeeFAO {
	
	@Value("${app.filedir}")
	private String filedir;
	
	
	@Value("${app.filename}")
	private String filename;

	/**
	 * @param createEmployeeList
	 * 
	 */
	@Override
	public void createEmployeeList(List<Employee> createEmployeeList) throws EmployeeException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(new File(filedir+filename), createEmployeeList);
		}catch(IOException ioExe) {
			throw new EmployeeException(ioExe.getMessage());
		}
		
	}
	
	/**
	 * @param updateEmployeeList
	 * 
	 */
	@Override
	public void updateEmployeeList(List<Employee> updateEmployeeList) throws EmployeeException {
		
	}

	/**
	 * @param deleteEmployeeList
	 * 
	 */
	@Override
	public void deleteEmployeeList(List<Employee> deleteEmployeeList) throws EmployeeException {
		
	}

	/**
	 * @param getEmployeeList
	 * 
	 * @ return list of an employee/
	 */
	@Override
	public List<Employee> getEmployeeList() throws EmployeeException {
		ObjectMapper mapper = new ObjectMapper();
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			employeeList = mapper.readValue(new File(filedir+filename),  new TypeReference<List<Employee>>(){} );
		
		} catch (IOException e) {
			throw new EmployeeException(e.getMessage());
		}
		return employeeList;
		
	}
	
	



}
