<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PhanAnhVu
  Date: 11/11/2019
  Time: 4:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/headercss.jsp" %>
    <title>Bills List</title>
</head>
<body>
<div class="main-menu">
    <jsp:include page="/main_menu.jsp"/>
</div>
<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1>Bills List</h1>
    </div>
</div>
<div class="container">
    <table class="table table-striped table-honer">
        <thead>
        <tr class="alert alert-primary">
            <th>Numerical order</th>
            <th>Time enter</th>
            <th>Time out</th>
            <th>Employee</th>
            <th>Table</th>
            <th>View</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items='${requestScope["bills"]}' var="bill">
            <tr>
                <td>${bill.getId_bill()}</td>
                <td>${bill.getTime_enter()}</td>
                <td>${bill.getTime_out()}</td>
                <td>${bill.getName_employee()}</td>
                <td>${bill.getName_table()}</td>
                <td><a href="/bills?action=view&id=${bill.getId_bill()}&table=${bill.getName_table()}&name=${bill.getName_employee()}"class="btn btn-primary" role="button">view</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
