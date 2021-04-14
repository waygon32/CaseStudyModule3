<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 4/13/2021
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wait</title>
</head>
<body>
<a href="/Admin/MainManager.jsp">Back</a>
<table>
    <tr>
        <td>Order ID</td>
        <td>Account</td>
        <td></td>

    </tr>

    <c:forEach var="orderList" items="${requestScope['orderList']}">
        <tr>
            <td><a href=""><c:out value="${orderList.orderId}"></c:out></a></td>
            <td><a href=""><c:out value="${orderList.account}"></c:out></a></td>
            <td><a href="/product?action=confirmOrder&orderID='${orderList.orderId}'">Confirm</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
