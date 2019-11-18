<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vinh
  Date: 4/20/18
  Time: 6:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/headercss.jsp" %>
    <title>Employees List</title>
</head>
<body>
<div class="main-menu">
    <jsp:include page="/main_menu.jsp"/>
</div>
<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1>Employees</h1>
        <div class="btn-group">
        <a href="${pageContext.request.contextPath}/employees?action=create" class="btn btn-info" role="button">Create
            new Employees</a>
            <a href="employees" class="btn btn-primary" role="button">All employees</a>
        </div>
    </div>
</div>
<div class="container">
    <form method="post" action="${pageContext.request.contextPath}/employees?action=search">
        <div class="input-group mb-3">
            <input type="text" class="form-control" name="search" placeholder="Search">
            <div class="input-group-append">
                <button class="btn btn-success" type="submit">Go</button>
            </div>
        </div>
    </form>
</div>
<div class="container">
    <table class="table table-striped">
        <thead>
        <tr class="alert alert-primary">
            <th>Name</th>
            <th>BirthDate</th>
            <th>ID</th>
            <th>Authority</th>
            <th>Gender</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items='${requestScope["employees"]}' var="employee">
            <tr>
                <td>
                    <a href="${pageContext.request.contextPath}/employees?action=view&id=${employee.getId()}">${employee.getName()}</a>
                </td>
                <td>${employee.getBirthday()}</td>
                <td>${employee.getIdEmployee()}</td>
                <td><c:choose>
                    <c:when test="${employee.getAuthority()}">
                        Chu
                    </c:when>
                    <c:otherwise>
                        NhanVien
                    </c:otherwise>
                </c:choose></td>
                <td><c:choose>
                    <c:when test="${employee.getGender()}">
                        Nam
                    </c:when>
                    <c:otherwise>
                        Nu
                    </c:otherwise>
                </c:choose></td>
                <td><a href="${pageContext.request.contextPath}/employees?action=edit&id=${employee.getId()}"
                       class="btn btn-info" role="button">Edit</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/employees?action=delete&id=${employee.getId()}"
                       class="btn btn-danger" role="button">Delete</a>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


</body>
</html>