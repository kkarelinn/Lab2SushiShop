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
    <title>EDIT current CATEGORY</title>
</head>
<body>
<h2>Edit current category</h2>
<form:form action="/categories/${category.ID}/edit" method="post" modelAttribute="category">
    <form:label path="title">title: </form:label> <form:input type="text" path="title"/>
    <form:label path="description" >description: </form:label> <form:input type="text" path="description" cssStyle="width: 500px"/>

    <input type="submit" value="Submit"/>
</form:form>

<br>
<form action="/" >
    <button>Main page </button>
</form>
</body>
</html>
