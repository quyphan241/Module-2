<%--
  Created by IntelliJ IDEA.
  User: BVMT
  Date: 12/11/2019
  Time: 10:55 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/headercss.jsp" %>
    <title>Deleting Employee</title>
</head>
<body>
<div class="jumbotron jumbotron-fuild">
    <div class="container">
        <h1>Are you sure delete employee?</h1>
        <a href="${pageContext.request.contextPath}/employees" class="btn btn-primary" role="button">Back to Employees
            list</a>
    </div>
</div>
<div class="container">
    <form method="post">
        <table class="table table-striped">
            <thead>
            <tr class="alert alert-primary">
                <th>Name</th>
                <th>Password</th>
                <th>Birthday</th>
                <th>IdCard</th>
                <th>Authority</th>
                <th>Gender</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${requestScope["employee"].getName()}</td>
                <td>${requestScope["employee"].getPassword()}</td>
                <td>${requestScope["employee"].getBirthday()}</td>
                <td>${requestScope["employee"].getIdEmployee()}</td>
                <td>
                    <c:choose>
                        <c:when test="${employee.getAuthority()}">
                            Chu
                        </c:when>
                        <c:otherwise>
                            Nhan Vien
                        </c:otherwise>
                    </c:choose>
                </td>
                <td><c:choose>
                    <c:when test="${employee.getGender()}">
                        Nam
                    </c:when>
                    <c:otherwise>
                        Nu
                    </c:otherwise>
                </c:choose></td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete Employees" class="btn btn-danger"></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>