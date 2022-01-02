
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
    <title>ADD NEW Client</title>
</head>
<body>
<p> ADD new client</p>
<form:form action="/clients/new" method="post" modelAttribute="client">

    <div>
        <form:label path="fullName">title: </form:label>
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
    <button>Main page </button>
</form>
</body>
</html>
