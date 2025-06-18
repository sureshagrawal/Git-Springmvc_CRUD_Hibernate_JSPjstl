package com.nsgacademy.springcrud.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DAOException.class)
    public String handleDAOException(DAOException e, Model model) {
        model.addAttribute("errorMessage", "Database error: " + e.getMessage());
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        model.addAttribute("errorMessage", "Unexpected error: " + e.getMessage());
        return "error";
    }
}

