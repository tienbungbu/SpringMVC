//package com.java.controller;
//
//import org.apache.log4j.Logger;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class ExceptionController {
//	private static Logger logger = Logger.getLogger(ExceptionController.class);
//	
//	@ExceptionHandler(value = {Exception.class})
//	public String exceptionAll(Exception exception) {
//		logger.error(exception);
//		return "error";
//	}
//}
