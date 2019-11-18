<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: BVMT
  Date: 06/11/2019
  Time: 3:21 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/headercss.jsp" %>
    <title>Employees List Search</title>
</head>
<body>
<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1>Searched Employees</h1>
        <a href="/employees">Back to Employees list</a>
    </div>
</div>
<div>
<table class="table table-striped table-hover">
    <thead>
    <tr>
        <th>Name</th>
        <th>Password</th>
        <th>BirthDay</th>
        <th>IdEmployee</th>
        <th>Gender</th>
        <th>Authority</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>

    <c:forEach items='${requestScope["employees"]}' var="employee">

        <tr>
            <td>${employee.getName()}</td>
            <td>${employee.getPassword()}</td>
            <td>${employee.getBirthday()}</td>
            <td>${employee.getIdEmployee()}</td>
            <td><c:choose>
            <c:when test="${employee.getAuthority()}">
                Chu
            </c:when>
            <c:otherwise>
                Nhan Vien
            </c:otherwise>
            </c:choose></td>
            <td>
                <c:choose>
                <c:when test="${employee.getGender()}">
                    Nam
                </c:when>
                <c:otherwise>
                    Nu
                </c:otherwise>
                </c:choose>
            </td>
            <td><a href="${pageContext.request.contextPath}/employees?action=edit&id=${employee.getId()}">edit</a></td>
            <td><a href="${pageContext.request.contextPath}/employees?action=delete&id=${employee.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>

