package com.lcwd.user.service.exception;

public class ResourseNotFoundException extends RuntimeException {

	public ResourseNotFoundException()
	{
		super("resourse not found on server ");
	}
	
	public ResourseNotFoundException(String message)
	{
		super( message );
	}
}
