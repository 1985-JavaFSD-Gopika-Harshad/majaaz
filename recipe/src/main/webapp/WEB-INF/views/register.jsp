<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <h2>Register</h2>
    <form action="/user/register" method="post">
        Username: <input type="text" name="username"><br>
        Email: <input type="email" name="email"><br>
        Password: <input type="password" name="password"><br>
        <input type="submit" value="Register">
    </form>
    <% 
        String error = (String) request.getAttribute("error");
        if (error != null && !error.isEmpty()) { 
    %>
        <p style="color:red"><%= error %></p>
    <% 
        } 
    %>
</body>
</html>
