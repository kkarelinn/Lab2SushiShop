
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
    <title>EDIT current Product</title>
</head>
<body>
<h2>Edit current product</h2>
<form:form action="/products/edit" method="post" modelAttribute="product">

    <form:input type="hidden" path="ID"/>
    <br>
    <div>
        <form:label path="title">title: </form:label>
        <form:input type="text" path="title"/>
        <form:errors path="title"/>
    </div>
    <br>
    <div>
        <form:label path="description">description: </form:label>
        <form:input type="text" path="description" cssStyle="width: 500px"/>
        <form:errors path="description"/>
    </div>
    <br>
    <div>
        <form:label path="priceUsd">price-usd: </form:label>
        <form:input type="double" path="priceUsd"/>
        <form:errors path="priceUsd"/>
    </div>
    <br>
    <div>
        <label>Category:</label>
        <form:select path="category_ID">
            <form:options items="${cats}"  itemLabel="title" itemValue="ID"/>
        </form:select>
    </div>
    <br>
    <div>
        <label>LinkProduct:</label>
        <form:select path="linkProd_ID">
            <form:options items="${prods}"  itemLabel="title" itemValue="ID"/>
        </form:select>
    </div>
    <br>
    <div>
        <input type="submit" value="Submit"/>
    </div>

</form:form>
<br>
<form action="/" >
    <button>Main page </button>
</form>
</body>
</html>
