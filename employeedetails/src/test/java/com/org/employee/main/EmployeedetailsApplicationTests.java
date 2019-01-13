package com.org.employee.main;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.employee.bean.Employee;
import com.org.employee.bean.Filter;
import com.org.employee.controller.EmployeeController;
import com.org.employee.service.EmployeeService;


@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeedetailsApplicationTests {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private EmployeeService service;
	
	@Test
	public void testGetEmployeeList() throws Exception {		
		List<Employee> employeeList = getEmployee();
		
		given(service.getEmployeeList()).willReturn(employeeList);
		
		mvc.perform(get("/admin/getEmployeeList").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk()).andExpect(jsonPath("$[0].id", is(employeeList.get(0).getId())));
		
	}
	@Test
	public void testCreateEmployee() throws Exception {
		List<Employee> employeeList = getEmployee();
		
		ObjectMapper mapper = new ObjectMapper();
        String jsonContent = mapper.writeValueAsString(employeeList);
		
		mvc.perform(put("/admin/createEmployee").content(jsonContent).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk()).andExpect(jsonPath("$.status").value("Success"));
	}
	@Test
	public void testUpdateEmployee() throws Exception {
		List<Employee> employeeList = getEmployee();
		
		ObjectMapper mapper = new ObjectMapper();
        String jsonContent = mapper.writeValueAsString(employeeList);
		
		mvc.perform(post("/admin/updateEmployee").content(jsonContent).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk()).andExpect(jsonPath("$.status").value("Success"));		
	}
	@Test
	public void testDeleteEmployee() throws Exception {
		List<Employee> employeeList = getEmployee();
		
		ObjectMapper mapper = new ObjectMapper();
        String jsonContent = mapper.writeValueAsString(employeeList);
		
		mvc.perform(delete("/admin/deleteEmployee").content(jsonContent).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk()).andExpect(jsonPath("$.status").value("Success"));		
	}
	@Test
	public void testEmployeeFilter() throws Exception {
		List<Employee> employeeList = getEmployee();
		Filter filter = new Filter();
		filter.setOperator("lt");
		filter.setValue(30);
		filter.setSort("asc");
		
		ObjectMapper mapper = new ObjectMapper();
        String jsonContent = mapper.writeValueAsString(filter);
        given(service.getEmployeeFilter(filter)).willReturn(employeeList);
		
		mvc.perform(post("/admin/getEmployeeFilter").content(jsonContent).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk()).andExpect(jsonPath("$.status").value("Success"));		
	}
	private List<Employee> getEmployee() {
		Employee employee = new Employee();
		employee.setId(101);
		employee.setFullName("TestUser");
		employee.setAge(30);
		employee.setSalary(10000.00);
		
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(employee);
		return employeeList;
	}

}


