package com.auth.login.controller;

import com.auth.login.model.Contact;
import com.auth.login.model.Referral;
import com.auth.login.model.User;
import com.auth.login.model.Admission;
import com.auth.login.repository.ContactRepository;
import com.auth.login.repository.ReferralRepository;
import com.auth.login.repository.UserRepository;
import com.auth.login.repository.AdmissionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdmissionRepository admissionRepository;

    // Signup endpoint
    @PostMapping("/signup")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody User user) {
        Map<String, String> response = new HashMap<>();
        try {
            userRepository.save(user);
            response.put("message", "User registered successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error during signup: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody User loginData) {
        Map<String, String> response = new HashMap<>();
        try {
            User user = userRepository.findByEmailAndPassword(loginData.getEmail(), loginData.getPassword());
            if (user != null) {
                response.put("message", "Login successful");
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "Invalid email or password");
                return ResponseEntity.status(401).body(response);
            }
        } catch (Exception e) {
            response.put("message", "Error during login: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }

    // Admission endpoint
    @PostMapping("/admission")
    public ResponseEntity<Map<String, String>> applyForAdmission(@RequestBody Admission admission) {
        Map<String, String> response = new HashMap<>();
        try {
            admissionRepository.save(admission);
            response.put("message", "Admission submitted successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error during admission: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
    @Autowired
    private ContactRepository contactRepository;

    @PostMapping("/contacts")
    public ResponseEntity<Map<String, String>> saveContact(@RequestBody Contact contact) {
        Map<String, String> response = new HashMap<>();
        try {
            contactRepository.save(contact);
            response.put("message", "Contact saved successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error saving contact: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }

    @Autowired
    private ReferralRepository referralRepository;

    @PostMapping("/referafriend")  // This must match your frontend API path
    public ResponseEntity<Map<String, String>> saveReferral(@RequestBody Referral referral) {
        Map<String, String> response = new HashMap<>();
        try {
            referralRepository.save(referral);
            response.put("message", "Referral saved successfully");
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.put("message", "Error Saving referral: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }

    }

}
