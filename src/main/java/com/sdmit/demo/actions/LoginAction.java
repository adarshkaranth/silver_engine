package com.sdmit.demo.actions;
 
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
 
	private String userId;
    private String password;
    private String errorMessage; 
 // Action method to handle the list operation
    public String login() {
     System.out.println("...................LoginAction:login");

     	if("admin".equals(userId) && "password".equals(password)) {
     		return SUCCESS;
     	}
     	else {
     		errorMessage = "Login failed: User Id or Password mismatch.";
     		addFieldError("userId", errorMessage);
     		return ERROR;
     	}
        // Return a success result  
    }
 
	public String getUserId() {
		return userId;
	}

 
	public void setUserId(String userId) {
		this.userId = userId;
	}

 
	public String getPassword() {
		return password;
	}
 

	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
     
}
