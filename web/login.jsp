
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Visitor Flow</title>
    <link rel="stylesheet" href="style.css">
    
</head>

<body>
    <div class="navbar">
        <div class="navbar-brand">Visitor Flow</div>
        <div class="navbar-links">
            <a href="home.jsp">Home</a>
            <a href="register.jsp">Register</a>
            <a href="login.jsp">Login</a>
        </div>
    </div>
    <div class="form-container">
        <h2>Login</h2>
        <form action="LoginServlet" method="post">
            <input type="text" name="username" placeholder="Username" required>
            <input type="password" name="password" placeholder="Password" required>
            <button type="submit">Login</button>
        </form>
        
    </div>
    <div style="color: red; font-weight: bold; margin-top: 20px; text-align: center;">
        <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
    </div>
    <footer>
        <p>&copy; 2024 Visitor Flow. All Rights Reserved.</p>
    </footer>
</body>
</html>
