
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
    <title>ADD Cart`s details</title>
</head>
<body>
<p> ADD Cart`s details</p>
<form:form  action="/carts/newCart" method="post" modelAttribute="cart">
    <form:label path="deliveryAddress">delivery Address: </form:label>
    <form:input type="text" path="deliveryAddress"/>
    <form:errors path="deliveryAddress"/>
    <label>Client:</label>
    <form:select path="client_ID">
        <form:options items="${clients}"  itemLabel="fullName" itemValue="ID"/>
    </form:select>


    <input type="submit" value="Submit"/>
</form:form>
<br>
<form action="/" >
    <button>Main page </button>
</form>
</body>
</html>
