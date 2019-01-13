package com.org.employee.exception;

/**
* The Employee Exception is a custom exception
*  which is used to return the customized
*  exception based upon an operation.
*  
* 
* @author  Dillibabu T
* @version 1.0
* @since   13-01-2019
*/
public class EmployeeException extends Exception{

	/**
	 * Default serial version added for serializable class.
	 */
	private static final long serialVersionUID = 1L;

	
	

	/**
	 * Default Constructor which constructs an exception.
	 */
	public EmployeeException() {
		super();
	}

	/**
	 * Argument Constructor which constructs an exception with 
	 * custom message.
	 */
	public EmployeeException(String message) {
		super(message);
	}


	
	

}
