package com.nsgacademy.springcrud.controller;

import com.nsgacademy.springcrud.dao.StudentDAO;
import com.nsgacademy.springcrud.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private StudentDAO studentDAO;

    @RequestMapping("/")
    public String redirectToHome(){
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String Home(Model m){
        List<Student> list = studentDAO.selectAllStudents();
        m.addAttribute("listStudents",list);
        return "student-list";
    }
    @RequestMapping("/new")
    public String New(){
        return "student-form";
    }
    @RequestMapping("/edit")
    public String Edit(@RequestParam("id") String id, Model m){
        int stid = Integer.parseInt(id);
        Student student = studentDAO.selectStudent(stid);
        m.addAttribute("student",student);
        return "student-form";
    }
    @RequestMapping(path="/insert", method = RequestMethod.POST)
    public String Insert(@ModelAttribute Student student){
        studentDAO.insertStudent(student);
        return "redirect:/home?success=Added Successfully";
    }
    @RequestMapping(path="/update", method = RequestMethod.POST)
    public String Update(@ModelAttribute Student student){
        studentDAO.updateStudent(student);
        return "redirect:/home?success=Updated Successfully";
    }
    @RequestMapping("/delete")
    public String Delete(@RequestParam("id") String id) {
        int stid = Integer.parseInt(id);
        studentDAO.deleteStudent(stid);
        return "redirect:/home?success=Deleted Successfully";
    }
}