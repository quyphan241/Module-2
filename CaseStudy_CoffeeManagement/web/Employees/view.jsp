<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/headercss.jsp" %>
    <title>View Employees</title>
</head>
<body>
<div class="jumbotron jumbotron-fuild">
    <div class="container">
        <h1>Information employee</h1>
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
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
