//package com.web.e_note.controller;
//
//import com.web.e_note.entity.User;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.ui.Model;
//
//@Controller
//public class RegistrationController {
//
//    @GetMapping("/register")
//    public String showRegistrationForm(Model model) {
//        model.addAttribute("user", new User());
//        return "register"; // View name (register.html or register.jsp)
//    }
//
//    @PostMapping("/register/save")
//    public String registerUser(@ModelAttribute User user, Model model) {
//        // Save the user (e.g., to a database)
//        System.out.println("Registered user: " + user);
//
//        // Redirect to login page or show success message
//        return "redirect:/login";
//    }
//}
