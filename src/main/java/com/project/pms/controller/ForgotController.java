package com.project.pms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/pms")
public class ForgotController {

    @PostMapping("/forgotpwd/{email}")
    public ResponseEntity<Integer> sendOTP(@PathVariable String email) {
        System.out.println("Received email: " + email);

        // Generate OTP of 4 digits
        Random random = new Random();
        int otp = 1000 + random.nextInt(9000); // Generate a random 4-digit OTP
        System.out.println("Generated OTP: " + otp);

        // Simulate sending OTP via email or SMS (not implemented in this example)
        return ResponseEntity.ok(otp);
    }
}
