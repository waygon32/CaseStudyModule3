<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/9/2021
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3 align="center"><a href="/product?action=test">Product Manager</a></h3>
<table border="1px solid" align="center" style="text-align: center">
    <tr>
        <td>ProductID</td>
        <td>TypeID</td>
        <td>Color</td>
        <td>Memory</td>
        <td>Price</td>
        <td>Quantity</td>
        <td>Describe</td>
    </tr>
    <c:forEach var="product" items="${requestScope['products']}">
        <tr>
            <td><c:out value="${product.productId}"></c:out></td>
            <td><c:out value="${product.typeId}"></c:out></td>
            <td><c:out value="${product.color}"></c:out></td>
            <td><c:out value="${product.memory}"></c:out></td>
            <td><c:out value="${product.price}"></c:out></td>
            <td><c:out value="${product.quantity}"></c:out></td>
            <td><c:out value="${product.describeProduct}"></c:out></td>

            <td><a href="/product?action=edit&id=${product.productId}">Edit</a></td>
            <td><a href="/product?action=delete&id=${product.productId}">Delete</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="9"><a href="/product?action=create">Add</a>
        </td> <td colspan="9"><a href="/product?action=menu">menu</a></td>
    </tr>
</table>
</body>
</html>