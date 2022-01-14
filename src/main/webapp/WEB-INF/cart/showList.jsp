<%--
  Created by IntelliJ IDEA.
  User: HomePC
  Date: 29.12.2021
  Time: 00:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>SuSHI SHOP</title>
    <script type="text/javascript">

    </script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<c:if test="${tempOrders.size() > 0}">
    <h2>Ваша корзина</h2>
    <table border="2" cellpadding="2" width="60%">
        <tr>
            <th>ID</th>
            <th>Продукт</th>
            <th>Категория</th>
            <th>Цена USD</th>
            <th>Количество</th>
            <th>Сумма ГРН</th>

        </tr>
        <c:forEach var="ord" items="${tempOrders}">
            <tr align="center">
                <td>${ord.product.ID}</td>
                <td>${ord.product.title}</td>
                <td>${ord.product.category.title}</td>
                <td>${ord.product.priceUsd}</td>
                <td>${ord.quantity}</td>
                <td>${ord.total_price_uah}</td>
            </tr>
        </c:forEach>
    </table>
    <h3>Общая сумма: ${tempCart.totalPrice_uah} грн</h3>
    <form action="/carts/details" method="get">
        <button>Оформить</button>
    </form>
    <form action="/carts/del" method="get">
        <button>Удалить корзину</button>
    </form>
</c:if>


    <h2>Choose our products</h2>
  <table border="2" cellpadding="2" width="60%">
        <tr><th>ID</th>
            <th>Product</th>
            <th>Description</th>
            <th>Category</th>
            <th>Price-USD</th>
            <th>to Cart?</th>

        </tr>
        <c:forEach var="mass" items="${products}">
      <tr align="center">
          <td>${mass.ID}</td>
          <td>${mass.title}</td>
          <td>${mass.description}</td>
          <td>${mass.category.title}</td>
          <td>${mass.priceUsd}</td>
          <td><form:form action="/carts/add" method="post" modelAttribute="order">
              <form:label path="quantity" > К-во: </form:label>
              <form:input type="int" cssStyle="width: 40" path="quantity"  />
              <form:errors path="quantity"/>

              <form:input type="hidden" path="product_ID" value="${mass.ID}"/>
              <input type="hidden" name="priceUsd" value="${mass.priceUsd}"/>
              <input type="hidden" name="prod_id" value="${mass.ID}"/>
              <input type="hidden" name="cat_id" value="${mass.category_id}"/>
              <input type="submit" value="Добавить"/>
            </form:form></td>

            </c:forEach>
    </table>
    <br>
    <form action="/">
        <button>Main page </button>
    </form>
</body>
</html>