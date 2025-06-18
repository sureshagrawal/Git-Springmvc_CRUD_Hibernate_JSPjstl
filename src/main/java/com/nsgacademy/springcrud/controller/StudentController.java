package com.nsgacademy.springcrud.controller;

import com.nsgacademy.springcrud.dao.StudentDAO;
import com.nsgacademy.springcrud.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StudentController {

    @Autowired
    private StudentDAO studentDAO;

    @GetMapping("/")
    public String homeRedirect() {
        return "redirect:/students";
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentDAO.findAll());
        return "student-list";
    }

    @GetMapping("/students/new")
    public String newStudentForm() {
        return "student-form";
    }

    @PostMapping("/students/save")
    public String saveStudent(@ModelAttribute Student student, Model model, RedirectAttributes redirectAttributes) {
        String error = validateForm(student.getName(), student.getEmail(), student.getMobile());
        if (error != null) {
            model.addAttribute("error", error);
            model.addAttribute("student", student); // repopulate
            return "student-form";
        }

        studentDAO.save(student);
        redirectAttributes.addFlashAttribute("success", "Student added successfully!");
        return "redirect:/students";
    }

    @GetMapping("/students/edit")
    public String editStudent(@RequestParam("id") int id, Model model) {
        Student student = studentDAO.findById(id);
        model.addAttribute("student", student);
        return "student-form";
    }

    @PostMapping("/students/update")
    public String updateStudent(@ModelAttribute Student student, Model model, RedirectAttributes redirectAttributes) {
        String error = validateForm(student.getName(), student.getEmail(), student.getMobile());
        if (error != null) {
            model.addAttribute("error", error);
            model.addAttribute("student", student);
            return "student-form";
        }

        studentDAO.update(student);
        redirectAttributes.addFlashAttribute("success", "Student updated successfully!");
        return "redirect:/students";
    }

    @GetMapping("/students/delete")
    public String deleteStudent(@RequestParam("id") int id, RedirectAttributes redirectAttributes) {
        studentDAO.delete(id);
        redirectAttributes.addFlashAttribute("success", "Student deleted successfully!");
        return "redirect:/students";
    }

    private String validateForm(String name, String email, String mobile) {
        if (name == null || name.trim().isEmpty()) {
            return "Name is required.";
        } else if (email == null || !email.contains("@")) {
            return "Valid email is required.";
        } else if (mobile == null || !mobile.matches("\\d{10}")) {
            return "Mobile number must be 10 digits.";
        }
        return null;
    }
}
