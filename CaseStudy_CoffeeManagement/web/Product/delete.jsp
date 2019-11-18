<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/12/2019
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting product</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@include file="/headercss.jsp" %>
</head>
<body>
<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1>Are you sure delete product?</h1>
        <a href="/products" class="btn btn-primary" role="button">Back to product list</a>
    </div>
</div>
<div class="container">
    <form method="post">
        <table class="table">
            <thead>
            <tr class="alert alert-primary">
                <th>Name</th>
                <th>Price</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${requestScope["product"].getName()}</td>
                <td>${requestScope["product"].getPrice()}</td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Delete product"class="btn btn-danger" role="button" style="float: right"></td>
            </tr>
            </tbody>
        </table>
        </fieldset>
    </form>
</div>
</body>
</html>
