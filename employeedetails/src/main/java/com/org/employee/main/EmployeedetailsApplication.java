package com.org.employee.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.org.employee.service.impl.CreateDirectoryServiceImpl;

@SpringBootApplication(scanBasePackages= {"com.org.employee"})
public class EmployeedetailsApplication {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication();
		ApplicationContext applicationContext = springApplication.run(EmployeedetailsApplication.class, args);
		
		CreateDirectoryServiceImpl createDir = (CreateDirectoryServiceImpl) applicationContext.getBean("createDirectoryServiceImpl");
		createDir.createDir();
			
	}

}

