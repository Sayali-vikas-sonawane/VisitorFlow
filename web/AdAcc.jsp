<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jakarta.servlet.http.*, jakarta.servlet.*"%>
<%
     
    String username = null;
    if (session != null) {
        username = (String) session.getAttribute("username");
    }
    else
    {
        response.sendRedirect("home.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Visitor Flow - Visitor Management System</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="navbar">
        <div class="navbar-brand">Visitor Flow</div>
        <div class="navbar-links" id="navbar-links">
            <a href="home.jsp">Home</a>
            <% if (username != null) { %>
            <div class="user-info">
                 <button style="width: 40px; height: 40px; border-radius: 50%; background-color: white; color: blue; border: 2px solid blue; font-size: 16px; display: flex; justify-content: center; align-items: center; cursor: pointer;"><%= username.charAt(0) %></button>
                <form action="logout.jsp" style="display: inline;">
                    <button type="submit" class="logout-button"><a href="logout.jsp">Logout</a>
    
                    </button>
                </form>
            </div>
            <% } else { %>
            <a href="login.jsp">Login</a>
            <a href="register.jsp">Register</a>
            <% } %>
        </div>
    </div>
        <div class="hero" style="margin-bottom: 5px;">
        <h1>Welcome to Visitor Flow</h1>
        <p id="welcome-message">Efficiently manage visitors with our innovative system</p>
        </div>
    <div class="main-content" style="margin-top: 0; padding-top: 0;">
        <% if (username != null) { %>
        <h1>Welcome, <%= username %>!</h1>
        <form action="AllRecordsServlet" method="get">
        <button type="submit" class="nav-button">All Records</button>
        </form>
        
        <form action="BlockedVisitorsServlet" method="get">
            <button type="submit" class="nav-button">Blocklist</button>
        </form>
        <% } else { %>
    <h1>You are not logged in.</h1>
    <p>Please <a href="login.jsp">login</a> to access this page.</p>
    <% } %>
       
    </div>
    
    <footer>
        <p>&copy; 2024 Visitor Flow. All Rights Reserved.</p>
        <p><a href="#privacy">Privacy Policy</a> | <a href="#terms">Terms of Service</a></p>
    </footer>
</body>
</html>
