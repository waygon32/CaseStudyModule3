<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/15/2021
  Time: 9:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px solid" align="center">
    <tr>
        <td colspan="4">Customer  Information</td>
    </tr>
    <tr>
        <td>Account</td>
        <td>Name</td>
        <td>Phone Number</td>
        <td>Address</td>
    </tr>
    <tr>
        <td><c:out value="${customer.account}"></c:out></td>
        <td><c:out value="${customer.name}"></c:out></td>
        <td><c:out value="${customer.phoneNumber}"></c:out></td>
        <td><c:out value="${customer.address}"></c:out></td>
    </tr>
</table>
<table border="1px solid">
    <tr>
        <td colspan="6">Transaction History</td>
    </tr>
    <tr>
        <td>Order Id</td>
        <td>Product Name</td>
        <td>Color</td>
        <td>Memory</td>
        <td>Quantity</td>
        <td>Price</td>
    </tr>

    <c:forEach var="product" items="${requestScope['listOldOrder']}">
        <tr>
            <td><c:out value="${product.productId}"></c:out></td>
            <td><c:out value="${product.name}"></c:out></td>
            <td><c:out value="${product.color}"></c:out></td>
            <td><c:out value="${product.memory}"></c:out></td>
            <td><c:out value="${product.quantity}"></c:out></td>
            <td><c:out value="${product.price}"></c:out></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
