<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <h2>Login</h2>
    <form action="/login" method="post">
        Username: <input type="text" name="username"><br>
        Password: <input ty1pe="password" name="password"><br>
        <input type="submit" value="Login">
    </form>
    <% 
        String error = (String) request.getAttribute("error");
        if (error != null && !error.isEmpty()) { 
    %>
        <p style="color:red"><%= error %></p>
    <% 
        } 
    %>
    <a href="/user/register">Don't have an account? Register</a>
</body>
</html>
