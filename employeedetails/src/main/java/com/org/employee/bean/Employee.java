package com.org.employee.bean;


/**
* The Employee bean class contains the properties 
* of an Employee which will be used to create,update
* and delete the employees. 
* 
* @author  Dillibabu T
* @version 1.0
* @since   13-01-2019
*/
public class Employee {
	
	private int id;
	private String fullName;
	private int age;
	private double salary;
	
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public boolean equals(Object obj) {		
		return this.id == ((Employee)obj).id;
	}
	@Override
	public int hashCode() {		
		return this.id;
	}
	

}
