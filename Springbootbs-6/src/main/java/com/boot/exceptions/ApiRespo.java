package com.boot.exceptions;

public class ApiRespo 
{

	private String message;
	private boolean status;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ApiResponce [message=" + message + ", status=" + status + "]";
	}
	public ApiRespo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
