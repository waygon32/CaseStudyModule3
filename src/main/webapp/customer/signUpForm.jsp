<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Sign Up</title>
</head>
<body>
<div class="col-lg-2 col-6 btn btn-outline-success" style="margin: auto; text-align: center">
    <a style="margin-left: auto; margin-top: 10px; margin-bottom: 10px"
       onclick="window.location.href='/customer?action=showMain'" method="post">Trang chủ</a>
</div>
    <form id="logreg-forms" action="/customer?action=signUpForm" method="post" class="form-signup">
        <a>${message}</a>
        <input type="text" id="user-name" name="account" class="form-control" placeholder="UserName" required="" autofocus="">
        <input type="password" pattern="(?=.*\d)(?=.*[a-z]).{6,}" title="mật khẩu cần có ít nhất một số và một chữ cái , ngắn nhất là 6 ký tự" name="password" id="user-pass" class="form-control" placeholder="Password" required autofocus="">
        <input type="password" pattern="(?=.*\d)(?=.*[a-z]).{6,}" name="rePassword" id="user-repeatpass" class="form-control" placeholder="Repeat Password" required autofocus="">
        <input type="text" name="name" class="form-control" placeholder="Full Name" required="" autofocus="">
        <input type="text" name="address" class="form-control" placeholder="Address" required="" autofocus="">
        <input type="number" name="phoneNumber" pattern="(?=.*[0-9]{9,});" title="Số điện thoại không hợp lệ" class="form-control" placeholder="Phone Number" required="" autofocus="">

        <button class="btn btn-primary btn-block" type="submit"><i class="fas fa-user-plus"></i> Sign Up</button>
    </form>
    <br>

<%--</div>--%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="../customer/login.js"></script>
</body>
</html>