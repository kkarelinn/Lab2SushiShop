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
<h2>You cart are added successfully</h2>
<table border="2" cellpadding="2" width="60%">
    <tr>
        <th>Product</th>
        <th>Description</th>
        <th>Price-USD</th>
        <th>Quantity</th>
        <th>Total price UAH</th>

    </tr>
    <c:forEach var="ord" items="${orders}">
        <tr>
            <th>${ord[1]}</th>
            <th>${ord[2]}</th>
            <th>${ord[3]}</th>
            <th>${ord[5]}</th>
            <th>${ord[6]}</th>
        </tr>
    </c:forEach>
</table>
<h3 >Total: ${cartAp.totalPriceUAH}</h3>
<h3>Delivery address: ${cartAp.deliveryAddr}</h3>
<h3>Client name: ${client.fullName}</h3>

<br>
<form action="/carts/del">
    <button>К списку товаров</button>
</form>
</body>
</html>