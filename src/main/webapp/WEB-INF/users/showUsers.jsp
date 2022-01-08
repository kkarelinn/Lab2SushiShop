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
        <c:forEach var="user" items="${userStr}">
        <tr>
            <td>${user[0]}</td>
            <td>${user[1]}</td>
            <td>${user[2]}</td>
            <td>${user[3]}</td>
            <td><a href="users/${user[0]}">edit</a></td>
            <td><a href="users/del/${user[0]}">delete</a></td>
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