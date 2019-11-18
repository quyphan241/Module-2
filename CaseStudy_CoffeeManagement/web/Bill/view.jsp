<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PhanAnhVu
  Date: 11/12/2019
  Time: 10:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/headercss.jsp" %>
    <title>View Bill Detail</title>
</head>
<body>
<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1>Bills Detail</h1>
        <h2>Table: ${table}</h2>
        <h3>Employee: ${name}</h3>
        <a href="/bills" class="btn btn-primary" role="button">Back to bill list</a>
    </div>
</div>
<div class="container">
<table class="table table-striped table-honer">
    <thead>
    <tr class="alert alert-primary">
        <th>Product</th>
        <th>Price</th>
        <th>Quantity</th>

    </tr>
    </thead>
    <tbody>
    <c:set var="total" value="${0}"/>
    <c:forEach items = '${requestScope["bills"]}' var="bill">
        <tr>

                <%--            <td>${bill.get}</td>--%>
            <td>${bill.getName_product()}</td>
            <td>${bill.getPrice()}</td>
            <td>${bill.getQuantity()}</td>
            <c:set var="total" value="${total + bill.getPrice() * bill.getQuantity()}" />
        </tr>
    </c:forEach>
    <tr class="alert alert-success">
        <th>Total:</th>
        <th>${total}</th>
        <td></td>
    </tr>
    </tbody>
<%--    <form method="post" action="/bills?action=search">--%>
<%--        <input name="inputSearch" type="text">--%>
<%--        <input type="submit" value="search">--%>
<%--    </form>--%>

</table>
</div>
</body>
</html>
