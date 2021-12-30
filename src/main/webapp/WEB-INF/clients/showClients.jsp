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
    <h2>Clients</h2>
    <table border="2" cellpadding="2" width="60%">
        <tr>
            <th>ID</th>
            <th>Full name</th>
            <th>Address</th>

        </tr>
        <c:forEach var="client" items="${clients}">
        <tr>
            <th>${client.ID}</th>
            <th>${client.fullName}</th>
            <th>${client.address}</th>
            <th><a href="clients/${client.ID}">edit</a></th>
            <th><a href="clients/del/${client.ID}">delete</a></th>
        </tr>
        </c:forEach>
    </table>

    <form action="/clients/new" >
        <button>AddNewUser</button>
    </form>
    <br>
    <form action="/" >
        <button>Main page </button>
    </form>
</body>
</html>