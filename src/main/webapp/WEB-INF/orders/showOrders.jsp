<%--
  Created by IntelliJ IDEA.
  User: HomePC
  Date: 29.12.2021
  Time: 00:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ taglib uri="http://www.springframework.org/tags" prefix="security" %>--%>
<html>
<head>
    <title>SuSHI SHOP</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<h2>Orders</h2>
<table border="2" cellpadding="2" width="60%">
    <tr>
        <th>ID</th>
        <th>Product ID</th>
        <th>Cart ID</th>
        <th>totalOrdPriceUAH</th>
        <th>quantity</th>
    </tr>
    <c:forEach var="order" items="${orders}">
        <tr align="center">
            <td>${order.ID}</td>
            <td>${order.product_ID}</td>
            <td>${order.cart_ID}</td>
            <td>${order.totalOrdPriceUAH}</td>
            <td>${order.quantity}</td>
            <th><a href="orders/${order.ID}">edit</a></th>
            <th><a href="orders/del/${order.ID}">delete</a></th>
        </tr>
    </c:forEach>
</table>

<br>
<form action="/">
    <button>Main page</button>
</form>
</body>
</html>