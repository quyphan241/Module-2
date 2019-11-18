<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/11/2019
  Time: 5:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@include file="/headercss.jsp" %>
</head>
<body>
<div class="main-menu">
    <jsp:include page="/main_menu.jsp" />
</div>
<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1>Products</h1>
        <div class="btn-group">
        <a href="/products?action=create" class="btn btn-info" role="button">Create new product</a>
            <a href="/products" class="btn btn-primary" role="button">All product</a>
        </div>
    </div>
</div>
<div class="container">
    <form method="post" action="${pageContext.request.contextPath}/products?action=search">
        <div class="input-group mb-3">
            <input type="text" class="form-control" name="search" placeholder="Search">
            <div class="input-group-append">
                <button class="btn btn-success" type="submit">Go</button>
            </div>
        </div>
    </form>
</div>
<div class="container">
<%--    <div>--%>
<%--        <form method="post" action="/products">--%>
<%--            <input type="text" name="search">--%>
<%--            <input type="text" name="action" value="search" hidden>--%>
<%--            <input type="submit" value="Search" class="btn btn-primary">--%>
<%--        </form>--%>
<%--    </div>--%>
    <table class="table table-striped table-hover">
        <thead>
        <tr class="alert alert-primary">
            <th>Name</th>
            <th>Price</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items='${requestScope["products"]}' var="product">
            <tr>
                <td><a href="products?action=view&id=${product.getId()}">${product.getName()}</a></td>
                <td>${product.getPrice()}</td>
                <td><a href="products?action=edit&id=${product.getId()}" class="btn btn-info" role="button">Edit</a>
                </td>
                <td><a href="products?action=delete&id=${product.getId()}" class="btn btn-danger"
                       role="button">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>