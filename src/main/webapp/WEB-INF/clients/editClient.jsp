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
<form:form action="/clients/edit" method="post" modelAttribute="client">
    <form:input type="hidden" path="ID"/>
    <div>
        <form:label path="fullName">full Name: </form:label>
        <form:input type="text" path="fullName"/>
        <form:errors path="fullName"/>
    </div>
    <div>
        <form:label path="address">address: </form:label>
        <form:input type="textID" path="address" cssStyle="width: 500px"/>
        <form:errors path="address"/>
    </div>
    <div>
        <input type="submit" value="Submit"/>
    </div>

    </form:form>

    <br>
    <form action="/">
        <button>Main page</button>
    </form>
</body>
</html>
