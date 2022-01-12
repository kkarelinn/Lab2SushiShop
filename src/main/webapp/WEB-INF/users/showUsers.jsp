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
    <h2>Users</h2>
    <table border="2" cellpadding="2" width="60%">
        <tr>
            <th>ID</th>
            <th>Full name</th>
            <th>my manager</th>
            <th>Access</th>

        </tr>
        <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.ID}</td>
            <td>${user.fullName}</td>
            <td>${user.man.fullName}</td>
            <td>${user.accessRole}</td>
            <td><a href="users/${user.ID}">edit</a></td>
            <td><a href="users/del/${user.ID}">delete</a></td>
        </tr>
        </c:forEach>
    </table>

    <form action="/users/new" >
        <button>AddNewUser</button>
    </form>
    <br>
    <form action="/">
        <button>Main page </button>
    </form>
</body>
</html>