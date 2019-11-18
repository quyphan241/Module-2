<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ryan
  Date: 11/11/2019
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <%@include file="/headercss.jsp" %>
    <title>List</title>
</head>
<body>
<div class="main-menu">
    <jsp:include page="/main_menu.jsp"/>
</div>
<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1>Table List</h1>
        <div class="btn-group">
            <a href="tables?action=create" class="btn btn-primary" role="button">Create Table</a>
            <a href="tables?action=findEmptyTable" class="btn btn-primary" role="button">Empty Table</a>
            <a href="tables?action=tableAction" class="btn btn-primary" role="button">Action Table</a>
            <a href="tables" class="btn btn-primary" role="button">All Table</a>
        </div>
    </div>
</div>
<div class="container">
    <table class="table table-striped">
        <thead>
        <tr class="alert alert-primary">
            <th>Local</th>
            <th>Capacity</th>
            <th>Status</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope['tables']}" var="table">
            <tr>
                <td>${table.getLocal()}</td>
                <td>${table.getCapacity()}</td>
                <td><c:choose>
                    <c:when test="${table.getIs_available()==1}"><p>Close</p></c:when>
                    <c:when test="${table.getIs_available()==0}"><p>Open</p></c:when>
                </c:choose>
                </td>
                <td><a href="tables?action=update&id_table=${table.getId_table()}" class="btn btn-info" role="button">Edit</a></td>
                <td><a href="tables?action=delete&id_table=${table.getId_table()}" class="btn btn-danger" role="button">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>

