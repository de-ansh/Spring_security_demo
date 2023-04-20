package com.example.springsecurityDemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/docs")
public class HomeController {

    @PreAuthorize("hasRole('Normal')")
    @GetMapping("/normal")
    public ResponseEntity<String>normaluser(){
        return ResponseEntity.ok("yes, Its a normal User");
    }


    @PreAuthorize("hasRole('Active')")
    @GetMapping("/home")
    public ResponseEntity<String>home(){
        return ResponseEntity.ok("this is Home Page");
    }

    @PreAuthorize("hasRole('Admin')")
    @GetMapping("/admin")
    public ResponseEntity<String>admin(){
        return ResponseEntity.ok("this is ADMIN Page");
    }
}
