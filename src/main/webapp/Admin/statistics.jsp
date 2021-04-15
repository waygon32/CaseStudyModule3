<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/15/2021
  Time: 2:18 AM
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
        <td colspan="5">Ban chay nhat</td>

    </tr>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Color</td>
        <td>Memory</td>
        <td>Total Quantity</td>
    </tr>
    <c:forEach var="bestSeller" items="${requestScope['bestSeller']}">
    <tr>
        <td><c:out value="${bestSeller.productId}"></c:out></td>
        <td><c:out value="${bestSeller.name}"></c:out></td>
        <td><c:out value="${bestSeller.color}"></c:out></td>
        <td><c:out value="${bestSeller.memory}"></c:out></td>
        <td><c:out value="${bestSeller.quantity}"></c:out></td>
    </tr>
    </c:forEach>
</table>
<table border="1px solid">
    <tr>
        <td colspan="5">Ban cham nhat</td>

    </tr>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Color</td>
        <td>Memory</td>
        <td>Total Quantity</td>
    </tr>
    <c:forEach var="badSeller" items="${requestScope['badSeller']}">
        <tr>
            <td><c:out value="${badSeller.productId}"></c:out></td>
            <td><c:out value="${badSeller.name}"></c:out></td>
            <td><c:out value="${badSeller.color}"></c:out></td>
            <td><c:out value="${badSeller.memory}"></c:out></td>
            <td><c:out value="${badSeller.quantity}"></c:out></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
