
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
    <title>ADD NEW Product</title>
</head>
<body>
<p> ADD new product</p>
<form:form  action="/new" method="post" modelAttribute="product">
    <div>
        <form:label path="title">title: </form:label>
        <form:input type="text" path="title"/>
        <form:errors path="title"/>
    </div>
    <div>
        <form:label path="description">description: </form:label>
        <form:input type="text" path="description" cssStyle="width: 500px"/>
        <form:errors path="description"/>
    </div>
    <div>
        <form:label path="priceUsd">price-usd: </form:label>
        <form:input type="double" path="priceUsd"/>
        <form:errors path="priceUsd"/>
    </div>
    <div>
        <input type="submit" value="Добавить"/>
    </div>

</form:form>
<br>
<form action="/" >
    <button>Main page </button>
</form>
</body>
</html>
