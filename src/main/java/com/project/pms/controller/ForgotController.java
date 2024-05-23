package com.project.pms.controller;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RestController;

// import java.util.Random;
// import org.springframework.web.bind.annotation.RequestMapping;


// @RestController
// @RequestMapping("/pms")
// public class ForgotController {

//     @PostMapping("/forgotpwd/{email}")
//     public ResponseEntity<Integer> sendOTP(@PathVariable String email) {
//         System.out.println("Received email: " + email);

//         // Generate OTP of 4 digits
//         Random random = new Random();
//         int otp = 100000 + random.nextInt(900000); // Generate a random 4-digit OTP
//         System.out.println("Generated OTP: " + otp);

//         // Simulate sending OTP via email or SMS (not implemented in this example)
//         return ResponseEntity.ok(otp);
//     }
// }


// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.project.pms.services.ForgotService;

// @RestController
// public class ForgotController {

//     @Autowired
//     private ForgotService ForgotService;

//     @GetMapping("/send-otp/{email}")
//     public String sendOtp(@RequestParam String email) {
//         String otp = ForgotController.generateOtp();
//         ForgotService.sendOtp(email, otp);
//         return "OTP sent to " + email;
//     }

//     private static String generateOtp() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'generateOtp'");
//     }
// }


// package com.project.pms.controller;
import com.project.pms.services.EmailService;

// import com.project.pms.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pms.dto.ForgotPasswordDTO;

import java.util.Random;

@RestController
@CrossOrigin
@RequestMapping("/pms")
public class ForgotController {

    @Autowired
    private EmailService emailService;
    
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
