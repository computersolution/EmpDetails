package com.org.employee.bean;

/**
* The Filter bean class contains the properties 
* for filtering an employee based on the user inputs.
*  
* 
* @author  Dillibabu T
* @version 1.0
* @since   13-01-2019
*/
public class Filter {
	
	private String operator;
	private int value;
	private String sort;
	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}
	/**
	 * @param opertator the operator to set
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}
	/**
	 * @return the sort
	 */
	public String getSort() {
		return sort;
	}
	/**
	 * @param sort the sort to set
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}
	
	

}
