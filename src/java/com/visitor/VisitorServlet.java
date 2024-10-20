package com.visitor;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.Random;


public class VisitorServlet extends HttpServlet {
    private static final String DIGITS = "0123456789";
    private static final int LENGTH = 5;
    private static final Random random = new Random();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String name = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone_number = request.getParameter("phone_number");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String purpose = request.getParameter("purpose");
        String additionalInfo = request.getParameter("additionalInfo");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        
        //Generating visitor id
        String visitorId=generatevisitorid();
        
        // Save visitor details to the database
        saveVisitorDetails(visitorId, name,lastName, email, phone_number, address, gender, purpose, additionalInfo, timestamp, false);

        // Generate QR code and send email
        String qrText = "Visitor ID: " + visitorId + "\nname: " + name + 
                        "\nLast Name: " + lastName + "\nEmail: " + email + "\nphoneNumber: " + phone_number +
                        "\nAddress: " + address + "\nGender: " + gender + "\nPurpose: " + purpose + 
                        "\nAdditional Info: " + additionalInfo;
        String qrFilePath = generateQRCode(qrText);
        sendEmailWithQRCode(email, qrFilePath,visitorId);

        response.getWriter().println("Visitor details submitted successfully!");
    }
    
    private String generatevisitorid()
    {       
    StringBuilder visitorID = new StringBuilder(LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            int index = random.nextInt(DIGITS.length());
            visitorID.append(DIGITS.charAt(index));
        }
        return visitorID.toString();
    }
    private void saveVisitorDetails(String visitorId, String name, String lastName, String email, String phone_number, String address, String gender, String purpose, String additionalInfo, Timestamp timestamp, boolean isBlock) {
        System.out.println("Start saving data");
        String url = "jdbc:mysql://localhost:3306/visitorinfo";
        String user = "root";
        String password = "sayali";
        
          
        try  {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("connection bean created");
            String sql = "INSERT INTO visitors (visitor_id, name, last_name, email, phone_number, address, gender, purpose, additional_info,submission_timestamp, is_block) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, visitorId);
            statement.setString(2, name);
            statement.setString(3, lastName);
            statement.setString(4, email);
            statement.setString(5, phone_number);
            statement.setString(6, address);
            statement.setString(7, gender);
            statement.setString(8, purpose);
            statement.setString(9, additionalInfo);
            statement.setTimestamp(10, timestamp);
            statement.setBoolean(11, isBlock);
            statement.executeUpdate();
            System.out.println("data added");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String generateQRCode(String text) {
        String filePath = "C:\\Users\\PCP\\OneDrive\\Documents\\NetBeansProjects\\visitor_registration\\qrimages\\qr.png";
        int width = 300;
        int height = 300;
        String fileType = "png";
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height);
            MatrixToImageWriter.writeToPath(bitMatrix, fileType, Paths.get(filePath));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return filePath;
    }

private void sendEmailWithQRCode(String recipientEmail, String qrFilePath, String visitorId) {
    // SMTP server configuration
    String host = "smtp.gmail.com"; // Replace with your SMTP server host
    final String username = "mahajanritu747@gmail.com"; // Replace with your email username
    final String password = "fzwv fssa hidx vmnl"; // Replace with your email password

    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
    });

    try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username)); // Set sender email address
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail)); // Set recipient email address dynamically
        message.setSubject("Your QR Code"); // Set email subject

        // Email body text
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText("Your visitor id : "+visitorId+"\nPlease find your QR code attached.");

        // Create multipart message to handle attachments
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        // Attach QR code image
        messageBodyPart = new MimeBodyPart();
        DataSource source = new FileDataSource("C:\\Users\\PCP\\OneDrive\\Documents\\NetBeansProjects\\visitor_registration\\qrimages\\qr.png"); // Path to your QR code image file
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName("QR.png"); // Set the filename for the attachment
        multipart.addBodyPart(messageBodyPart);

        // Set the complete message content
        message.setContent(multipart);

        // Send the email
        Transport.send(message);

        System.out.println("Email sent successfully to " + recipientEmail);
    } catch (MessagingException e) {
        throw new RuntimeException(e);
    }
}

    }

