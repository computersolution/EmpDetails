package com.org.employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.org.employee.bean.Employee;
import com.org.employee.bean.Filter;
import com.org.employee.bean.Message;
import com.org.employee.exception.EmployeeException;
import com.org.employee.service.EmployeeService;

/**
* The EmployeeController is a controller class
* which is used to manage an operation of an 
* employee that is create,update,delete,get list
* of an employee and filter an employee based 
* on the condition. 
*  
* 
* @author  Dillibabu T
* @version 1.0
* @since   13-01-2019
*/

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	/**
	 * @param createEmployeeList
	 * @return   response message of an operation.
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/admin/createEmployeeList", consumes = "application/json", produces="application/json")
	@ResponseBody
	public Message createEmployee(@RequestBody List<Employee> createEmployeeList) {
		Message message = new Message();
		try {
			service.createEmployee(createEmployeeList);
			message.setStatus("Success");
			message.setMessage("Saved Successfully");
		} catch (EmployeeException empException) {
			message.setStatus("Failed");
			message.setMessage(empException.getMessage());
			
		}
		return message;		
	}
	
	
	/**
	 * @param updateEmployeeList
	 * @return response message of an operation.
	 */
	@RequestMapping(method=RequestMethod.POST, value="/admin/updateEmployeeList", consumes = "application/json" , produces="application/json")
	@ResponseBody
	public Message updateEmployee(@RequestBody List<Employee> updateEmployeeList) {
		Message message = new Message();
		try {
			service.updateEmployee(updateEmployeeList);
			message.setStatus("Success");
			message.setMessage("Updated Successfully");
		} catch (EmployeeException empException) {
			message.setStatus("Failed");
			message.setMessage(empException.getMessage());
		}
		return message;		
	}

	/**
	 * @param deleteEmployeeList
	 * @return  response message of an operation.
	 */
	@RequestMapping(method=RequestMethod.DELETE, value="/admin/deleteEmployeeList", consumes = "application/json" , produces="application/json")
	@ResponseBody
	public Message deleteEmployee(@RequestBody List<Employee> deleteEmployeeList) {
		Message message = new Message();
		try {
			service.deleteEmployee(deleteEmployeeList);
			message.setStatus("Success");
			message.setMessage("Deleted Successfully");
		} catch (EmployeeException empException) {
			message.setStatus("Failed");
			message.setMessage(empException.getMessage());
		}
		return message;		
	}
	
	
	/**
	 * @return list of employees
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/admin/getEmployeeList", produces="application/json")
	@ResponseBody
	public List<Employee> getEmployeeList() {
		List<Employee> empList = new ArrayList<Employee>();
		try {
			 empList = service.getEmployeeList();
		} catch (EmployeeException empException) {
			empException.getMessage();
		}
		return empList;
	}
	
	
	/**
	 * @param filter
	 * @return employee object
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/admin/getFilterEmployeeList", produces="application/json")
	@ResponseBody
	public Object getEmployeeFilter(@RequestBody Filter filter ) {
		List<Employee> empList = null;
		Message message = new Message();
		try {
			 empList = service.getEmployeeFilter(filter);
			 if(empList == null || empList.isEmpty()) {
				 message.setStatus("Success");
				 message.setMessage("Record Not Found");
				 return message;
			 }
		} catch (EmployeeException empException) {
				message.setStatus("Failed");
				message.setMessage(empException.getMessage());
				return message;
		}
		return empList;
	}
	
}
