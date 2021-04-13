<%--
  Created by IntelliJ IDEA.
  User: Thien
  Date: 4/9/2021
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            margin: 0;
            padding: 0;
            font-family: sans-serif;
            background: #34495e;
        }
        .box{
            width: 300px;
            padding: 40px;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
            background: #191919;
            text-align: center;
        }
        .box h1{
            color: white;
            text-transform: uppercase;
            font-weight: 500;
        }
        .box input[type="text"], .box input[type = "password"], .box input[type="number"]{
            border: 0;
            background: none;
            display: block;
            margin: 20px auto;
            text-align: center;
            border: 2px solid #3498db;
            padding: 14px 10px;
            width: 200px;
            outline: none;
            color: white;
            border-radius: 24px;
            transition: 0.25s;
        }
        .box input[type="text"]:focus, .box input[type = "password"]:focus ,input[type="number"]:focus{
            width: 280px;
            border-color: #2ecc71;
        }

        .box input[type= "submit"], .box input[type="button"]{
            border: 0;
            background: none;
            display: block;
            margin: 20px auto;
            text-align: center;
            border: 2px solid #2ecc71;
            padding: 14px 40px;
            outline: none;
            color: white;
            border-radius: 24px;
            transition: 0.25s;
            cursor: pointer;
        }
        .box input[type="submit"]:hover{
            background: #3fff53;
        }
        .box input[type="button"]:hover{
            background: #3fff53;
        }
    </style>
</head>
<body>
<form action="/customer?action=signUpForm" method="post" class="box">
    <h1>Sign Up</h1>
    <input type="text" name="account" placeholder="Username" required>
    <input type="password" name="password" placeholder="Password" id="password" required>
    <input type="password" name="rePassword" placeholder="RePassword" id="repassword" required>
    <input type="text" name="name" placeholder="Họ và tên" required>
    <input type="text" name="address" placeholder="Địa chỉ" required>
    <input type="number" name="phoneNumber" placeholder="Số điện thoại" required>
    <input type="submit" value="Tạo tài khoản">
    <input type="button" value="quay về trang chủ" onclick="window.location.href='/customer/main.jsp'">
</form>
</body>
</html>
