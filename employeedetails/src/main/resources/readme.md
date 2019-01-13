#Project Title: Employee Details

#Description of the Project
	This Employee Details project is developed to create an endpoints for Create,Update,Delete,Fetch and finally filter 
	the employee list based on their age limit.

#Getting Started:
#Prerequisites
	Recommended Java Version : 1.8 and above
	IDE : Eclipse (or) STS
	Build : Apache Maven

#Technology Stack
	Java Version : 1.8
	Spring Boot  : 2.1.2
	Maven Version: 3.6

#Project Setup
	Download an application from the Github and then import the same to an IDE. After the successful import of the project 
	check the java version in the build path.Once all set, then open the Application.properties and then check the drive of the file path.
	mentioned drive should be available to create the directory and file.
	

#Project Build
	Since, it'smaven project we need to build an application with help of the maven. Now, right click the pom.xml and select Run As then choose 
		Maven Build...
			Goal as 'clean install'
	Now, the project will begin the build with the test cases. First the test cases will run then the spring will start.
	If all goes fine then project will be sucessful with test cases.
	
#Deployment and Run an Application
	After the successful build, now open the class name called	EmployeedetailsApplication.class and right click the class
	and select Run As Java Application, now the application get started after the start need to verify the path and filename
	mentioned which is mentioned in application.properties.
	
#Endpoint Access
	Create An EmployeeList:
		http://localhost:8080/admin/createEmployeeList
		#Example Data:
		[{"id":101,"fullName":"TestUser-101","age":30,"salary":50000.0},{"id":102,"fullName":"TestUser-102","age":40,"salary":50000.0},
		{"id":103,"fullName":"TestUser-103","age":50,"salary":50000.0},{"id":104,"fullName":"TestUser-104","age":60,"salary":50000.0}]
	Update An EmployeeList:
		http://localhost:8080/admin/updateEmployeeList
		#Example Data:
		[{"id":101,"fullName":"TestUser-10","age":30,"salary":50000.0},{"id":102,"fullName":"TestUser-20","age":40,"salary":50000.0},
		{"id":103,"fullName":"TestUser-30","age":50,"salary":50000.0},{"id":104,"fullName":"TestUser-40","age":60,"salary":50000.0}]
	Delete An EmployeeList:
		http://localhost:8080/admin/deleteEmployeeList
		#Example Data:
		[{"id":101,"fullName":"TestUser-10","age":30,"salary":30000.0}]
	Fetch An EmployeeList:
		http://localhost:8080/admin/getEmployeeList
	Filter An EmployeeList: 
		http://localhost:8080/admin/getFilterEmployeeList
		#Example Data:
		{"operator":"eq", "value":30, "sort":"asc"}
		


#Summary
	This emplyee details project is being used for CRUD operations of list of employees.
