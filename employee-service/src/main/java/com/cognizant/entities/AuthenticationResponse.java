package com.cognizant.entities;

public class AuthenticationResponse {
    private String token;
    private String message;
    private Employee employee;

    public AuthenticationResponse(String token, String message, Employee employee) {
        this.token = token;
        this.message = message;
        this.employee = employee;
    }

    public String getToken() {
        return token;
    }

    public String getMessage() {
        return message;
    }

	public Employee getEmployee() {
		return employee;
	}
    
    
}
