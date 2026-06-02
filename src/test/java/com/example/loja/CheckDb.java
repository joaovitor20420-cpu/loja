package com.example.loja;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class CheckDb {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:h2:file:./database/ecommerce-db", "SA", "");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, email, role FROM users");
        System.out.println("--- USERS IN DB ---");
        while(rs.next()) {
            System.out.println("ID: " + rs.getString("id") + " | EMAIL: " + rs.getString("email") + " | ROLE: " + rs.getString("role"));
        }
        conn.close();
    }
}
