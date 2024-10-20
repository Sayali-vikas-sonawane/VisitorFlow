

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>logout</title>
    </head>
    <body>
        <%
		session.invalidate();
		response.sendRedirect("home.jsp");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		
	%>
    </body>
</html>
