package com.code.ghsonar.controller;

import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController {

    private String unusedVariable = "This is never used"; // Code Smell: Unused variable

    @GetMapping("/{id}")
    public String getUser(@PathVariable int id) {
        if (id == 1) {
            return "Admin";
        }
        return "User " + id;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        String hardcodedPassword = "1234"; // Security Issue: Hardcoded credentials

        if ("admin".equals(username) && hardcodedPassword.equals(password)) {
            return "Login successful";
        }
        return "Invalid credentials";
    }

    @GetMapping("/read-file")
    public String readFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("test.txt")); // Bug: Unclosed resource
            return reader.readLine();
        } catch (IOException e) {
            return "Error reading file";
        }
    }
}
