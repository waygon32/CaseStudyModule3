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
<table border="1px solid " align="center">
    <tr>
        <td>Order ID</td>
        <td>Account</td>
        <td>Total</td>
        <td></td>
        <td></td>

    </tr>

    <c:forEach var="order" items="${requestScope['orderList']}">
        <tr>
            <td><a href="/customer?action=orderDetail&account=${order.account}&orderId=${order.orderId}"><c:out
                    value="${order.orderId}"></c:out></a></td>
            <td> <a href="/customer?action=customerInformation&account=${order.account} "><c:out
                    value="${order.account}"></c:out></a></td>
            <td><c:out value="${order.totalPrices}"></c:out></td>
            <td><a href="/product?action=confirmOrder&orderID='${order.orderId}'">Confirm</a></td>

        </tr>
    </c:forEach>

</table>
</form>
</body>
</html>
