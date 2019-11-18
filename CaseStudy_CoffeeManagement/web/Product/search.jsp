<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/12/2019
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search result</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@include file="/headercss.jsp" %>
</head>
<body>
<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1>Search Product Result</h1>
        <a href="/products" class="btn btn-primary" role="button">Back to product list</a>
    </div>
</div>
<div class="container">
<table class="table table-striped">
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
    </tbody>
</table>
</div>
</body>
</html>
