package com.QuizApp.QuizApp.OTP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/otp")
public class OTPController {
    @Autowired
    private OTPService otpService;

    @GetMapping(path = "/sendOtp")
    public ResponseEntity<String> sendOTP(@RequestParam Long phoneNumber) {
        return otpService.sendOTp(phoneNumber);
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verifyOTP(@RequestParam String api_key,
                                            @RequestParam String phoneNumber,
                                            @RequestParam String otp) {
        try {
            ResponseEntity<String> verificationResult = otpService.verifyOTP(api_key, phoneNumber, otp);
            return verificationResult;
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Exception occurred : " + e.getMessage());
        }
    }
}
