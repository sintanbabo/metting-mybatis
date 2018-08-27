package com.sintanbabo.metting.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sintanbabo.metting.error.MettingNotFoundException;

@ControllerAdvice
public class MettingControllerAdvice {

	@ExceptionHandler(Exception.class)
	public String handleException(Exception exception, Model model) {
		model.addAttribute("exception", exception);
		return "exception-page";
	}
	
	@ExceptionHandler(MettingNotFoundException.class)
	public String handelMettingNotFoundException(Exception exception, Model model) {
		model.addAttribute("exception", exception);
		return "exception-page";
	}
}
