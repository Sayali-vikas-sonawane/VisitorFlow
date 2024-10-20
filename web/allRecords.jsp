<%@page import="com.visitor.Visitor"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jakarta.servlet.http.*, jakarta.servlet.*"%>
<%
     
    String username = null;
    
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Visitor Flow - Visitor Management System</title>
    <link rel="stylesheet" href="style.css">
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
         .block-button {
            color: red;
             border: none;
            background: none;
             cursor: pointer;
            font-weight: bold;
       }
         .block-button:hover {
             text-decoration: underline;
         }
    </style>
</head>
<body>
    <div class="navbar">
        <div class="navbar-brand">Visitor Flow</div>
        <div class="navbar-links" id="navbar-links">
            <a href="index.jsp">Home</a>
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
    <div class="hero">
        <h1>Welcome to Visitor Flow</h1>
        <p id="welcome-message">Efficiently manage visitors with our innovative system</p>
    </div>
    <div class="search-form" style="margin: 20px;">
        <form action="AllRecordsServlet" method="get">
            <label for="visitorId">Search by Visitor ID:</label>
            <input type="text" id="visitorId" name="visitorId" placeholder="Enter Visitor ID" value="<%= request.getParameter("visitorId") %>">
            <button type="submit">Search</button>
        </form>
    </div>
    <table>
        <thead>
            <tr>
                <th>Visitor ID</th>
                <th>Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Phone Number</th>
                <th>Address</th>
                <th>Gender</th>
                <th>Purpose</th>
                <th>Additional Info</th>
                <th>Submission Timestamp</th>
                 <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <% 
                List<Visitor> visitors = (List<Visitor>) request.getAttribute("visitors");
                if (visitors != null && !visitors.isEmpty()) {
                    for (Visitor visitor : visitors) {
            %>
            <tr>
                <td><%= visitor.getVisitorId() %></td>
                <td><%= visitor.getName() %></td>
                <td><%= visitor.getLastName() %></td>
                <td><%= visitor.getEmail() %></td>
                <td><%= visitor.getPhoneNumber() %></td>
                <td><%= visitor.getAddress() %></td>
                <td><%= visitor.getGender() %></td>
                <td><%= visitor.getPurpose() %></td>
                <td><%= visitor.getAdditionalInfo() %></td>
                <td><%= visitor.getSubmissionTimestamp() %></td>
                 <td>
                    <% if (username != null && visitor.getisBlock()==false) { %>
                    <form action="BlockVisitorServlet" method="post" style="display: inline;">
                        <input type="hidden" name="blockVisitorId" value="<%= visitor.getVisitorId() %>">
                        <button type="submit" class="block-button">Block
                        </button>
                    </form>
                    <% }
                     else { %>
             <span>Blocked</span>
              <% } %>
          </td>
                 
            </tr>
            <% 
                    } 
                } else { 
            %>
            <tr>
                <td colspan="10">No visitors found.</td>
            </tr>
            <% } %>
        </tbody>
    </table>
    <footer>
        <p>&copy; 2024 Visitor Flow. All Rights Reserved.</p>
        <p><a href="#privacy">Privacy Policy</a> | <a href="#terms">Terms of Service</a></p>
    </footer>
</body>
</html>
