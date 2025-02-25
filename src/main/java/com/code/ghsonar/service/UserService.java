package com.code.ghsonar.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String processUser(String input) {
        if (input.length() > 5) { // Bug: Possible null pointer dereference
            return "Valid user";
        }
        return "Invalid user";
    }

    public String inefficientLoop() {
        String result = "";
        for (int i = 0; i < 10; i++) {
            result += i; // Performance Issue: Inefficient string concatenation in loop
        }
        return result;
    }

}
