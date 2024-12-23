//package com.web.e_note.controller;
//
//import com.web.e_note.entity.User;
//import com.web.e_note.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/register")
//    public String registerUser(@ModelAttribute User user, Model model) {
//        userService.save(user);
//        model.addAttribute("message", "User registered successfully!");
//        return "dashboard.html"; // Replace with the actual view name (e.g., a Thymeleaf or JSP page)
//    }
//}
