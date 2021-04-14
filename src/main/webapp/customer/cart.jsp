<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/12/2021
  Time: 11:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="product?action=buy" method="post">
    <table border="1px solid" align="center">
        <tr>
            <td>Name</td>
            <td>Color</td>
            <td>Memory</td>
            <td>Quantity</td>
            <td>Prices</td>
        </tr>
        <c:forEach var="product" items="${requestScope['listCart']}">
            <tr>
                <td><c:out value="${product.name}"></c:out></td>
                <td><c:out value="${product.color}"></c:out></td>
                <td><c:out value="${product.memory}"></c:out></td>
                <td><c:out value="${product.quantity}"></c:out></td>
                <td><c:out value="${product.price}"></c:out></td>
                <td><a href="/product?action=deleteInCart&name=${product.color}">Delete</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td>Total prices</td>
            <td colspan="5"><c:out value="${total}"></c:out></td>
        </tr>
    </table>
    <input type="submit" value="Buy now">
    <a href="/product?action=menu">Back</a>
</form>
</body>
</html>
