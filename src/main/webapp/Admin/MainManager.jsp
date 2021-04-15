<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/13/2021
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manager</title>
</head>
<body>
<table align="center" style="width: 500px ; text-align:center ;  height: 300px " border="1px solid ">
    <tr>
        <td>Funtion</td>
        <td>Describe</td>
        <td>GOOO</td>
    </tr>
    <tr>
        <td>CRUD</td>
        <td>CRUD cung cấp những tính năng như thêm , sửa , xóa sản phẩm hệ thống</td>
        <td><a href="/product">Go</a></td>
    </tr>
    <tr>
        <td>Quản lý đơn hàng</td>
        <td>Quản lí thông tin đơn hàng , trạng thái đơn hàng , thông tin về khách hàng , sản phẩm </td>
        <td><a href="/product?action=orderManagement">Go</a></td>
    </tr>
    <tr>
        <td>Thống kê </td>
        <td>Thống kê tổng doanh thu, top 5 sản phẩm bán chạy nhất</td>
        <td><a href="/product?action=statistics">Go</a></td>
    </tr>
</table>
</body>
</html>
