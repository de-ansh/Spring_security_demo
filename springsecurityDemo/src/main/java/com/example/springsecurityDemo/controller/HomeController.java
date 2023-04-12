package com.example.springsecurityDemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/docs")
public class HomeController {

    @GetMapping("/normal")
    public ResponseEntity<String>normaluser(){
        return ResponseEntity.ok("yes, Its a normal User");
    }


    @GetMapping("/home")
    public ResponseEntity<String>home(){
        return ResponseEntity.ok("this is Home Page");
    }

    @GetMapping("/admin")
    public ResponseEntity<String>admin(){
        return ResponseEntity.ok("this is Home Page");
    }
}
