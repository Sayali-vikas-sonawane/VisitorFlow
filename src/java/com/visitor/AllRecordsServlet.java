
package com.visitor;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import jakarta.servlet.RequestDispatcher;
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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;



@WebServlet(name = "AllRecordsServlet", urlPatterns = {"/AllRecordsServlet"})
public class AllRecordsServlet extends HttpServlet {

    private VisitorDAO visitorDAO = new VisitorDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchId = request.getParameter("visitorId");
        List<Visitor> visitors;

        if (searchId != null && !searchId.trim().isEmpty()) {
            visitors = visitorDAO.getVisitorsById(searchId);
        } else {
            visitors = visitorDAO.getAllVisitors();
        }

        request.setAttribute("visitors", visitors);
        RequestDispatcher dispatcher = request.getRequestDispatcher("allRecords.jsp");
        dispatcher.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
