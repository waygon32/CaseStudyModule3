<%@ page import="com.model.Customer" %><%--
  Created by IntelliJ IDEA.
  User: Thien
  Date: 4/9/2021
  Time: 4:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
<%--    <%--%>
<%--        HttpSession session1 = request.getSession(false);--%>
<%--//            Customer customer1=(Customer)session1.getAttribute("account");--%>
<%--    %>--%>
    <p>${message1}</p>
</div>
<button onclick="window.location.href='/customer?action=loginForm'">Đăng nhập</button>
<%--<button onclick="window.location.href='/customer?action=signUpForm'">Đăng ký</button>--%>
<button onclick="window.location.href='/customer?action=logOut'">Đăng xuất</button>
</body>
</html>
