package com.example.demo.util;

public class ResponseUtil {
	public static SuccessBuilder buildSuccess(String message) {
		return new SuccessBuilder(true,message);		
	}
	public static SuccessBuilder buildSuccess() {
		return new SuccessBuilder(true,"SUCCESS");		
	}
	
	public static SuccessBuilder buildError() {
		return new SuccessBuilder(false,"ERROR");
	}
	
	public static SuccessBuilder buildError(String message) {
		return new SuccessBuilder(false,message);
	}
	

}
