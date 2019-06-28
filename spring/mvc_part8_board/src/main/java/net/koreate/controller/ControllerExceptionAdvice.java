package net.koreate.controller;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ControllerExceptionAdvice {
	
	@ExceptionHandler(Exception.class)
	private ModelAndView errorModelAndView(Exception e) {
		System.out.println("예외 발생");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("common/error_common");
		mav.addObject("exception",e);
		System.out.println(e.getMessage());
		return mav;
	}
	
	@ExceptionHandler(NullPointerException.class)
	private ModelAndView errorModelAndView(NullPointerException e) {
		System.out.println("예외 발생");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("common/error_common");
		mav.addObject("exception",e);
		System.out.println(e.getMessage());
		return mav;
	}
	
	@ExceptionHandler(SQLException.class)
	private ModelAndView errorModelAndView(SQLException e) {
		System.out.println("예외 발생");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("common/error_common");
		mav.addObject("exception",e);
		System.out.println(e.getMessage());
		return mav;
	}
}
