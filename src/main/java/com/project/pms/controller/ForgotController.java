package com.project.pms.controller;

// package com.project.pms.controller;
import com.project.pms.services.EmailService;
import com.project.pms.services.UserService;

// import com.project.pms.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pms.dto.ForgotPasswordDTO;
import com.project.pms.model.User;

import java.util.Random;

@RestController
@CrossOrigin
@RequestMapping("/pms")
public class ForgotController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserService userService;
    
    @PostMapping("/forgotpwd")
    public ResponseEntity<String> sendOTP(@RequestBody ForgotPasswordDTO forgotPasswordDTO) {
        String email = forgotPasswordDTO.getEmail();
        int otp = forgotPasswordDTO.getOtp();
    
        System.out.println("Received email: " + email);

        System.out.println("Generated OTP: " + otp);

        // Send OTP via email
        emailService.sendOtp(email, otp);

        return ResponseEntity.ok("OTP sent to " + email);
    }
}
