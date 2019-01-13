package com.org.employee.bean;

/**
* The Message bean class contains the properties 
* to return the status and the message of an 
* operation. 
* 
* @author  Dillibabu T
* @version 1.0
* @since   13-01-2019
*/

public class Message {

	private String status;
	private String message;
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
