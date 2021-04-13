<%--
  Created by IntelliJ IDEA.
  User: Thien
  Date: 4/9/2021
  Time: 3:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="../customer/login.css">
</head>
<body>
<form  action="/customer?action=loginForm" method="post" class="box">
    <h1> Login </h1>
    <input type="text" name="account" placeholder="Username" required>
    <input type="password" name="password" placeholder="Password"required>
    <p style="color: azure">${message}</p>
    <input type="submit" name="" value="Login">
    <input type="button" onclick="window.location.href='/customer?action=signUpForm'" value="Sign up">
</form>
</body>
</html>
