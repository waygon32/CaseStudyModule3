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
    <style>
        #form {
            margin: auto;
        }
    </style>
    <title>Title</title>
</head>
<body>
<h3 align="center">ALL OF OUR PRODUCT</h3>
<div align="center">
    <form action="product?action=searchMenu" method="post">
        <input type="text" name="search">
        <input type="submit" value="Search">
    </form>
</div>
<a href="/product?action=cart">Cart</a>
<table border="1px solid" align="center" style="text-align: center">
    <tr>
        <td>Name</td>
        <td>Color</td>
        <td>Memory</td>
        <td>Price</td>
        <td>Describe</td>
        <td>Buy</td>
    </tr>
    <c:forEach var="product" items="${requestScope['products']}">
        <tr>
            <td><c:out value="${product.name}"></c:out></td>
            <td><c:out value="${product.color}"></c:out></td>
            <td><c:out value="${product.memory}"></c:out></td>
            <td><c:out value="${product.price}"></c:out></td>
            <td><c:out value="${product.describeProduct}"></c:out></td>

            <td><a href="/product?action=addToCart&id=${product.productId}">Add to Cart</a></td>

        </tr>
    </c:forEach>

    <tr>
    </tr>
</table>
</body>
</html>
