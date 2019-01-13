package com.org.employee.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.employee.bean.Employee;
import com.org.employee.bean.Filter;
import com.org.employee.exception.EmployeeException;
import com.org.employee.fao.EmployeeFAO;
import com.org.employee.service.EmployeeService;

/**
*  The EmployeeServiceImpl Implementation class is used to
*  perform an operation of create,update,delete,get the 
*  details and filter an employee based on the user input.
*  
* 
* @author  Dillibabu T
* @version 1.0
* @since   13-01-2019
*/

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeFAO employeeFAO;
	
	/**
	 * @param createEmployeeList
	 * 
	 */

	@Override
	public void createEmployee(List<Employee> createEemployeeList) throws EmployeeException {
		List<Employee> empList = employeeFAO.getEmployeeList();
		int empListSize = empList.size();
		for (Employee employee : createEemployeeList) {
			if (!empList.contains(employee)) {
				empList.add(employee);
			}
		}
		if (empListSize < empList.size()) {
			employeeFAO.createEmployeeList(empList);
		}

	}
	
	/**
	 * @param updateEmployeeList
	 * 
	 */

	@Override
	public void updateEmployee(List<Employee> updateEmployeeList) throws EmployeeException {
		List<Employee> empList = employeeFAO.getEmployeeList();
		for (Employee employee : updateEmployeeList) {
			if (empList.contains(employee)) {
				int indexOf = empList.indexOf(employee);
				empList.set(indexOf, employee);
			}
		}
		employeeFAO.createEmployeeList(empList);
	}
	
	/**
	 * @param deleteEmployeeList
	 * 
	 */

	@Override
	public void deleteEmployee(List<Employee> deleteEmployeeList) throws EmployeeException {
		List<Employee> empList = employeeFAO.getEmployeeList();
		for (Employee employee : deleteEmployeeList) {
			if (empList.contains(employee)) {
				empList.remove(employee);
			}
		}
		employeeFAO.createEmployeeList(empList);

	}
	
	/**
	 *@return List of an employee.
	 * 
	 */

	@Override
	public List<Employee> getEmployeeList() throws EmployeeException {
		List<Employee> empList = employeeFAO.getEmployeeList();
		return empList;
	}
	
	/**
	 * @param Filter obj
	 * @retrun the filtered employee obj.
	 * 
	 */
	@Override
	public List<Employee> getEmployeeFilter(Filter filter) throws EmployeeException {

		List<Employee> empList = employeeFAO.getEmployeeList();

		List<Employee> filterEmployee = null;
		if (filter.getOperator().equalsIgnoreCase("lt")) {

			filterEmployee = empList.stream().filter(employee -> filter.getValue() > employee.getAge())
					.collect(Collectors.toList());

		} else if (filter.getOperator().equalsIgnoreCase("lte")) {

			filterEmployee = empList.stream().filter(employee -> filter.getValue() >= employee.getAge())
					.collect(Collectors.toList());

		} else if (filter.getOperator().equalsIgnoreCase("gt")) {

			filterEmployee = empList.stream().filter(employee -> filter.getValue() < employee.getAge())
					.collect(Collectors.toList());

		} else if (filter.getOperator().equalsIgnoreCase("gte")) {

			filterEmployee = empList.stream().filter(employee -> filter.getValue() <= employee.getAge())
					.collect(Collectors.toList());

		} else if (filter.getOperator().equalsIgnoreCase("eq")) {
			filterEmployee = empList.stream().filter(employee -> filter.getValue() == employee.getAge())
					.collect(Collectors.toList());

		} else if (filter.getOperator().equalsIgnoreCase("ne")) {
			filterEmployee = empList.stream().filter(employee -> filter.getValue() != employee.getAge())
					.collect(Collectors.toList());
		}

		if (filterEmployee != null) {

			if (filter.getSort().equalsIgnoreCase("asc")) {

				Collections.sort(filterEmployee, (e1, e2) -> e1.getAge() - e2.getAge());
			} else {

				Collections.sort(filterEmployee, (e1, e2) -> e2.getAge() - e1.getAge());
			}
		}

		return filterEmployee;

	}

}
