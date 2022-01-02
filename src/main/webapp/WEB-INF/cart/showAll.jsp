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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    </head>
<body>
    <h2>All CARTS</h2>
    <table border="2" cellpadding="2" width="60%">
        <tr>
            <th>ID</th>
            <th>User ID</th>
            <th>Client ID</th>
            <th>Total price UAH</th>
            <th>Date</th>
            <th>deliveryAddr</th>
        </tr>
        <c:forEach var="cart" items="${carts}">
        <tr>
            <th>${cart.ID}</th>
            <th>${cart.user_ID}</th>
            <th>${cart.client_ID}</th>
            <th>${cart.totalPriceUAH}</th>
            <th>${cart.date}</th>
            <th>${cart.deliveryAddr}</th>
            <th><a href="del/${cart.ID}">delete</a></th>
        </tr>
        </c:forEach>
    </table>
    <br>
    <form action="/">
        <button>Main page </button>
    </form>
</body>
</html>