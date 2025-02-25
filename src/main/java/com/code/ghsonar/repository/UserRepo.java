package com.code.ghsonar.repository;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Repository
public class UserRepo {

    public boolean checkUserExists(String username) {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
             Statement stmt = conn.createStatement()) {

            String query = "SELECT * FROM users WHERE username = '" + username + "'"; // Security Issue: SQL Injection
            ResultSet rs = stmt.executeQuery(query);
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
