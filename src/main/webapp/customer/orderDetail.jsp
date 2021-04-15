<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/15/2021
  Time: 11:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px solid">
    <tr>
        <td colspan="6"> Order <c:out value="${orderId}" >Information </c:out>  </td>
    </tr>
    <tr>
        <td>Account</td>
        <td>Product Name</td>
        <td>Color</td>
        <td>Memory</td>
        <td>Quantity</td>
        <td>Price</td>

    </tr>

    <c:forEach var="product" items="${requestScope['listOrder']}">
        <tr>
            <td><c:out value="${account}"></c:out></td>
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
