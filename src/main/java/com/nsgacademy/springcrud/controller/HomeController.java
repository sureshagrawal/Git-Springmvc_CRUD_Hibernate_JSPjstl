package com.nsgacademy.springcrud.controller;

import com.nsgacademy.springcrud.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String Home(){
        return "student-list";
    }
    @RequestMapping("/new")
    public String New(){
        return "student-form";
    }
    @RequestMapping("/edit")
    public String Edit(){
        return "student-form";
    }
    @RequestMapping(path="/insert", method = RequestMethod.POST)
    public String Insert(@ModelAttribute Student student){
        System.out.println(student);
        return "student-list";
    }
    @RequestMapping(path="/update", method = RequestMethod.POST)
    public String Update(){
        return "student-list";
    }
    @RequestMapping("/delete")
    public String Delete(){
        return "student-list";
    }

}
