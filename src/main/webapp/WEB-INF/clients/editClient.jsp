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
    <title>EDIT current Client</title>
</head>
<body>
<h2>Edit current client</h2>
<form:form action="/clients/${client.ID}/edit" method="post" modelAttribute="client">
    <form:label path="fullName">title: </form:label> <form:input type="text" path="fullName"/>
    <form:label path="address">description: </form:label> <form:input type="textID" path="address"/>


    <input type="submit" value="Submit"/>
</form:form>

<br>
<form action="/" >
    <button>Main page </button>
</form>
</body>
</html>
