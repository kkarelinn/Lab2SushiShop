<%--
  Created by IntelliJ IDEA.
  User: HomePC
  Date: 28.12.2021
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html >
<head>
    <title text="${main}">SuShi Internet shop panel</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    </head>
<body>
<h2>SuShi Shop</h2>
<security:authorize access="hasRole('ADMIN')">

    <table cellpadding="2" width="60%">
        <tr>
            <th><form action="/products" >
                <button>View PRODUCTS</button>
            </form></th>
            <th><form action="/categories">
                <button>View CATEGORIES of products</button>
            </form></th>
            <th><form action="/users">
                <button>View USERS</button>
            </form></th>
            <th><form action="/clients" >
                <button>View CLIENTS</button>
            </form></th>
            <th><form action="/carts/allcarts" >
                <button>View CARTS</button>
            </form></th>
            <th><form action="/orders/" >
                <button>View ORDERS</button>
            </form></th>

        </tr>
    </table>
</security:authorize>
<security:csrfInput/>

<form action="/carts/" >
    <button>BUY SuShi</button>
</form>
<br>
<a href="/login" > log IN </a>
<br>
<a href="/logout" > log OUT </a>

</body>
</html>

