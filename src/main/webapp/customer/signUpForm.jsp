<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Thien--%>
<%--  Date: 4/9/2021--%>
<%--  Time: 11:02 AM--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<form action="/customer?action=signUpForm" method="post" class="box">--%>
<%--    <h1>Sign Up</h1>--%>
<%--    <input type="text" name="account" placeholder="Username" required>--%>
<%--    <input type="password" name="password" placeholder="Password" id="password" required>--%>
<%--    <input type="password" name="rePassword" placeholder="RePassword" id="repassword" required>--%>
<%--    <input type="text" name="name" placeholder="Họ và tên" required>--%>
<%--    <input type="text" name="address" placeholder="Địa chỉ" required>--%>
<%--    <input type="number" name="phoneNumber" placeholder="Số điện thoại" required>--%>
<%--    <input type="submit" value="Tạo tài khoản">--%>
<%--    <input type="button" value="quay về trang chủ" onclick="window.location.href='/customer/main.jsp'">--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link rel="stylesheet" href="../customer/style.css">
    <title>Login</title>
</head>
<body>
<%--<div id="logreg-forms">--%>
<%--    <form class="form-signin" action="/customer?action=loginForm" method="post">--%>
<%--        <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Sign in</h1>--%>
<%--        <input type="text" name="account" id="inputEmail" class="form-control" placeholder="UserName" required="" autofocus="">--%>
<%--        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required="">--%>

<%--        <button class="btn btn-success btn-block" type="submit"><i class="fas fa-sign-in-alt"></i> Sign in</button>--%>
<%--        <a href="#" id="forgot_pswd">Forgot password?</a>--%>
<%--        <hr>--%>
<%--        <!-- <p>Don't have an account!</p>  -->--%>
<%--        <button class="btn btn-primary btn-block" type="button" id="btn-signup"><i class="fas fa-user-plus"></i> Sign up New Account</button>--%>
<%--    </form>--%>

<%--    <form action="/reset/password/" class="form-reset">--%>
<%--        <input type="text" id="resetEmail" class="form-control" placeholder="UserName" required="" autofocus="">--%>
<%--        <button class="btn btn-primary btn-block" type="submit">Reset Password</button>--%>
<%--        <a href="#" id="cancel_reset"><i class="fas fa-angle-left"></i> Back</a>--%>
<%--    </form>--%>

    <form id="logreg-forms" action="/customer?action=signUpForm" method="post" class="form-signup">

        <input type="text" id="user-name" name="account" class="form-control" placeholder="UserName" required="" autofocus="">
        <input type="password" name="password" id="user-pass" class="form-control" placeholder="Password" required autofocus="">
        <input type="password" name="repassword" id="user-repeatpass" class="form-control" placeholder="Repeat Password" required autofocus="">
        <input type="text" name="name" class="form-control" placeholder="Full Name" required="" autofocus="">
        <input type="text" name="address" class="form-control" placeholder="Address" required="" autofocus="">
        <input type="text" name="phoneNumber" class="form-control" placeholder="Phone Number" required="" autofocus="">

        <button class="btn btn-primary btn-block" type="submit"><i class="fas fa-user-plus"></i> Sign Up</button>
        <a href="#" id="cancel_signup"><i class="fas fa-angle-left"></i> Back</a>
    </form>
    <br>

<%--</div>--%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="../customer/login.js"></script>
</body>
</html>