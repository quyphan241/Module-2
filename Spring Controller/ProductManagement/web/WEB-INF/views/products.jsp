<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/24/2019
  Time: 5:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products List</title>
</head>
<body>
<h1>Products</h1>
<p><a href="/new">Add new product</a></p>
<p>There are ${products.size()} products in this list.</p>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Price</td>
        <td>Manufactor</td>
        <td>Description</td>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.getId()}</td>
            <td><a href="/view?id=${product.getId()}"> ${product.getName()}</a></td>
            <td>${product.getPrice()}</td>
            <td>${product.getManufactor()}</td>
            <td>${product.getDescription()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
