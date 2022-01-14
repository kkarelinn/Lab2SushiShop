<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HomePC
  Date: 29.12.2021
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EDIT current User</title>
</head>
<body>
<h2>Edit current user</h2>
<form:form action="/users/${user.ID}/edit" method="post" modelAttribute="user">
    <form:label path="fullName">full Name: </form:label> <form:input type="text" path="fullName"/>
    <label>manager:</label>
    <form:select path="manager">
        <form:options items="${userMan}" itemLabel="fullName" itemValue="ID"/>
    </form:select>
    <label>role:</label>
    <form:select path="accessRole">
        <form:options items="${roles}" itemLabel="name" itemValue="name"/>
    </form:select>
    <input type="submit" value="Submit"/>
</form:form>

<br>
<form action="/">
    <button>Main page </button>
</form>
</body>
</html>
