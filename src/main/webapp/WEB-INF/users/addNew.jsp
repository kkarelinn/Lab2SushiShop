
<%--
  Created by IntelliJ IDEA.
  User: HomePC
  Date: 29.12.2021
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>ADD NEW User</title>
</head>
<body>
<p> ADD new user</p>
<form:form  action="/users" method="post" modelAttribute="user">
    <form:label path="fullName">fullName: </form:label> <form:input type="text" path="fullName"/>
    <label>manager:</label>
    <form:select path="manager">
        <form:options items="${userMan}"  itemLabel="fullName" itemValue="ID"/>
    </form:select>
    <label>role:</label>
    <form:select path="accessRole">
        <form:options items="${roles}"  itemLabel="name" itemValue="name"/>
    </form:select>
    <input type="submit" value="Submit"/>
</form:form>
<br>
<form action="/" >
    <button>Main page </button>
</form>
</body>
</html>
