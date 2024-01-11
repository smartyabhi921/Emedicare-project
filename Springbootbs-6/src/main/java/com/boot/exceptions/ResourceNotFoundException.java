package com.boot.exceptions;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException

{

	private String resourceName;
	private String feildName;
	private int fieldVlaue;
	public ResourceNotFoundException(String resourceName, String feildName, int fieldVlaue) {
		super(String.format("%s not found with %s : %d",resourceName,feildName,fieldVlaue));
		this.resourceName = resourceName;
		this.feildName = feildName;
		this.fieldVlaue = fieldVlaue;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getFeildName() {
		return feildName;
	}
	public void setFeildName(String feildName) {
		this.feildName = feildName;
	}
	public int getFieldVlaue() {
		return fieldVlaue;
	}
	public void setFieldVlaue(int fieldVlaue) {
		this.fieldVlaue = fieldVlaue;
	}
	@Override
	public String toString() {
		return "ResourceNotFoundException [resourceName=" + resourceName + ", feildName=" + feildName + ", fieldVlaue="
				+ fieldVlaue + "]";
	}
	public ResourceNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public ResourceNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public ResourceNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
