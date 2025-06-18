package com.nsgacademy.springcrud.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DAOException.class)
    public String handleDAOException(DAOException ex, Model model) {
        model.addAttribute("errorMessage", "Database Error: " + ex.getMessage());
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handleGenericException(Exception ex, Model model) {
        model.addAttribute("errorMessage", "Unexpected Error: " + ex.getMessage());
        return "error";
    }
}

