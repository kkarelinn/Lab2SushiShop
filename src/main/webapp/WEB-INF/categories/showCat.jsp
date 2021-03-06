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
<h2>Categories of products</h2>
<table border="2" width="60%">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Description</th>
        <th>Date</th>
    </tr>
    <c:forEach var="category" items="${categories}">
        <tr align="center">
            <td>${category.ID}</td>
            <td>${category.title}</td>
            <td>${category.description}</td>
            <td>${category.date}</td>
            <td><a href="categories/${category.ID}">edit</a></td>
            <td><a href="categories/del/${category.ID}">delete</a></td>
        </tr>
    </c:forEach>
</table>

<form action="/categories/new">
    <button>Add New Category of Products</button>
</form>
<br>
<form action="/">
    <button>Main page</button>
</form>

</body>
</html>