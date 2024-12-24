package com.web.e_note.controller;

import com.web.e_note.dto.UserDto;
import com.web.e_note.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/note")
public class AuthController {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;


    public AuthController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "users/register";
    }

    @PostMapping("/register/save")
    public String registerUser(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model) {
        if (userService.findUserByUsername(userDto.getUsername()).isPresent()) {
            result.rejectValue("username", null, "This username is already registered");
        }
        if (result.hasErrors()) {
            return "users/register";
        }
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword())); // Encrypt password
        userService.saveUser(userDto);
        return "redirect:/dashboard";
    }


    @GetMapping("/dashboard")
    public String showNotePage() {
        return "dashboard"; // Redirect to the note page after successful registration
    }

//    @GetMapping("/login")
//    public String showLoginForm(Model model) {
//        model.addAttribute("user", new User());
//        return "login";
//    }

}
