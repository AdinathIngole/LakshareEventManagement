package com.LakshareEventManagement.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.thymeleaf.exceptions.TemplateInputException;

@ControllerAdvice
public class GlobalExceptionHandler {
	 @ExceptionHandler(TemplateInputException.class)
	    public String handleTemplateInputException(TemplateInputException ex, Model model) {
	        model.addAttribute("error", ex.getMessage());
	        return "error";  // Return to a custom error page
	    }

}
