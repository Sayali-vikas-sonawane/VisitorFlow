package com.visitor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VisitorDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/visitorinfo";
    private static final String USER = "root";
    private static final String PASSWORD = "sayali";

    public List<Visitor> getAllVisitors() {
        List<Visitor> visitors = new ArrayList<>();
        String sql = "SELECT * FROM visitors";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) 
            
           {
            
            while (rs.next()) {
                String visitorId = rs.getString("visitor_id");
                String name = rs.getString("name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String phone_number = rs.getString("phone_number");
                String address = rs.getString("address");
                String gender = rs.getString("gender");
                String purpose = rs.getString("purpose");
                String additionalInfo = rs.getString("additional_info");
                Timestamp submissionTimestamp = rs.getTimestamp("submission_timestamp");
                boolean isBlocked = rs.getBoolean("is_block");
                
                Visitor visitor = new Visitor(visitorId, name, lastName, email, phone_number, address, gender, purpose, additionalInfo, submissionTimestamp, isBlocked);
                visitors.add(visitor);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("visitors added");
        return visitors;
    }
    
    
    public List<Visitor> getVisitorsById(String visitorId) {
        List<Visitor> visitors = new ArrayList<>();
        String sql = "SELECT * FROM visitors WHERE visitor_id = ?";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, visitorId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String id = rs.getString("visitor_id");
                    String name = rs.getString("name");
                    String lastName = rs.getString("last_name");
                    String email = rs.getString("email");
                    String phone_number = rs.getString("phone_number");
                    String address = rs.getString("address");
                    String gender = rs.getString("gender");
                    String purpose = rs.getString("purpose");
                    String additionalInfo = rs.getString("additional_info");
                    Timestamp submissionTimestamp = rs.getTimestamp("submission_timestamp");
                    boolean isBlocked = rs.getBoolean("is_block");
                    
                    Visitor visitor = new Visitor(id, name, lastName, email, phone_number, address, gender, purpose, additionalInfo, submissionTimestamp, isBlocked);
                    visitors.add(visitor);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return visitors;
    }
    public List<Visitor> getBlockedVisitors() {
    
    List<Visitor> blockedVisitors = new ArrayList<>();
        String sql = "SELECT * FROM visitors where is_block=true";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) 
            
           {
            
            while (rs.next()) {
                String visitorId = rs.getString("visitor_id");
                String name = rs.getString("name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String phone_number = rs.getString("phone_number");
                String address = rs.getString("address");
                String gender = rs.getString("gender");
                String purpose = rs.getString("purpose");
                String additionalInfo = rs.getString("additional_info");
                Timestamp submissionTimestamp = rs.getTimestamp("submission_timestamp");
                boolean isBlocked = rs.getBoolean("is_block");
                
                Visitor visitor = new Visitor(visitorId, name, lastName, email, phone_number, address, gender, purpose, additionalInfo, submissionTimestamp, isBlocked);
                blockedVisitors.add(visitor);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("visitors added");
        return blockedVisitors;
}

    public void blockVisitor(String visitorId) {
        String sql = "UPDATE visitors SET is_block = TRUE WHERE visitor_id = ?";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, visitorId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void unblockVisitor(String visitorId) {
        String sql = "UPDATE visitors SET is_block = FALSE WHERE visitor_id = ?";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, visitorId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
