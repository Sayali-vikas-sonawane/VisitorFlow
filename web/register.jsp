
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register - Visitor Flow</title>
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
        <h2>Register</h2>
        <form action="RegisterServlet" method="post">
            <input type="text" name="username" id="username" placeholder="Username" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="email" name="email" placeholder="Email" required>
            <input type="text" name="phone" placeholder="Phone Number" required>
            <button type="submit">Register</button>
        </form>
    </div>
    <footer>
        <p>&copy; 2024 Visitor Flow. All Rights Reserved.</p>
    </footer>
</body>
</html>
