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
    <h2>Products</h2>
    <table border="2" cellpadding="0.5"width="70%">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Description</th>
            <th>Date</th>
            <th>Price-USD</th>
            <th>category_ID</th>
            <th>linkProd_ID</th>
        </tr>
        <c:forEach var="product" items="${products}" >
        <tr align="center">
            <td>${product.ID}</td>
            <td>${product.title}</td>
            <td>${product.description}</td>
            <td>${product.date}</td>
            <td>${product.priceUsd}</td>
            <td>${product.category_ID}</td>
            <td>${product.linkProd_ID}</td>
            <th><a href="products/${product.ID}">edit</a></th>
            <th><a href="products/del/${product.ID}">delete</a></th>
        </tr>
        </c:forEach>
    </table>

    <form action="products/new">
        <button>AddNewProduct</button>
    </form>
    <br>
    <form action="/">
        <button>Main page </button>
    </form>
</body>
</html>