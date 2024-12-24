package com.web.e_note.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderUtil {

    public static void main(String[] args) {
        // Using BCryptPasswordEncoder for password encoding
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Example passwords
        String password1 = "bharti";
        String password2 = "admin";

        // Encoding the passwords
        String encodedPassword1 = passwordEncoder.encode(password1);
        String encodedPassword2 = passwordEncoder.encode(password2);

        // Printing encoded passwords
        System.out.println("Encoded password for 'bharti': " + encodedPassword1);
        System.out.println("Encoded password for 'admin': " + encodedPassword2);
    }
}
