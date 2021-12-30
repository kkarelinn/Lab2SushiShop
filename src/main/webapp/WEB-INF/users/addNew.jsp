
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
    <form:label path="manager">manager_ID: </form:label> <form:input type="int" path="manager"/>
    <form:label path="accessRole">access Role: </form:label> <form:input type="text" path="accessRole"/>
    <input type="submit" value="Submit"/>
</form:form>
<br>
<form action="/" >
    <button>Main page </button>
</form>
</body>
</html>
