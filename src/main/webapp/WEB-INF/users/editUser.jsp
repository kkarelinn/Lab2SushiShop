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
    <form:label path="fullName">title: </form:label> <form:input type="text" path="fullName"/>
    <form:label path="manager">description: </form:label> <form:input type="int" path="manager"/>
    <form:label path="accessRole">access Role: </form:label> <form:input type="text" path="accessRole"/>

    <input type="submit" value="Submit"/>
</form:form>

<br>
<form action="/">
    <button>Main page </button>
</form>
</body>
</html>
