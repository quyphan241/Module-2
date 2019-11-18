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
    <title>Edit Employees</title>
</head>
<body>
<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1>Edit Employees</h1>
        <p>
            <a href="/employees" class="btn btn-primary" role="button">Back to employees list</a>
        </p>
        <p>
            <c:if test='${requestScope["message"] != null}'>
            <span class="alert alert-success" >${requestScope["message"]}</span>
            </c:if>
        </p>
    </div>
</div>
<div class="container">
    <form method="post" class="needs-validation" novalidate>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name"  value="${requestScope["employee"].getName()}" name="name" required>
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <div class="form-group">
            <label for="price">Password:</label>
            <input type="password" class="form-control" id="price" value="${requestScope["employee"].getPassword()}" name="password" required>
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <input type="text" class="form-control" id="description"  value="${requestScope["employee"].getIdEmployee()}" name="id_card_number" required>
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <div class="form-group">
            <label for="birthday">BirthDay: :</label>
            <input type="Date" class="form-control" id="birthday"  value="${requestScope["employee"].getBirthday()}" name="birthday" required>
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <div class="form-group">
            <label for="gender">Gender:</label>
            <select name="gender" id="gender">
                <c:choose>
                    <c:when test="${employee.getGender()==false}">
                        <option selected  value="false">Nu</option>
                        <option  value="true">Nam</option>
                    </c:when>
                    <c:when test="${employee.getGender()}">
                        <option selected value="true">Nam</option>
                        <option  value="false">Nu</option>
                    </c:when>
                </c:choose>
            </select>
        </div>
        <div class="form-group">
            <label for="authority">Authority:</label>
            <select name="authority" id="authority">
                <c:choose>
                    <c:when test="${employee.getAuthority()==false}">
                        <option selected  value="false">NhanVien</option>
                        <option  value="true">Chu</option>
                    </c:when>
                    <c:when test="${employee.getAuthority()}">
                        <option selected value="true">Chu</option>
                        <option  value="false">NhanVien</option>
                    </c:when>
                </c:choose>
            </select>
        </div>
        <button type="submit" class="btn btn-info">Submit</button>
    </form>
    <script>
        // Disable form submissions if there are invalid fields
        (function() {
            'use strict';
            window.addEventListener('load', function() {
                // Get the forms we want to add validation styles to
                var forms = document.getElementsByClassName('needs-validation');
                // Loop over them and prevent submission
                var validation = Array.prototype.filter.call(forms, function(form) {
                    form.addEventListener('submit', function(event) {
                        if (form.checkValidity() === false) {
                            event.preventDefault();
                            event.stopPropagation();
                        }
                        form.classList.add('was-validated');
                    }, false);
                });
            }, false);
        })();
    </script>
</div>
<%--<form method="post">--%>
<%--    <fieldset>--%>
<%--        <legend>Employees information</legend>--%>
<%--        <table>--%>
<%--                    <tr>--%>
<%--                        <td>Name: </td>--%>
<%--                        <td><input type="text" name="name" id="name" value="${requestScope["employee"].getName()}"></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <td>Password: </td>--%>
<%--                        <td><input type="text" name="password" id="price" value="${requestScope["employee"].getPassword()}"></td>--%>
<%--                    </tr>--%>

<%--                    <tr>--%>
<%--                        <td>ID: </td>--%>
<%--                        <td><input type="text" name="id_card_number" id="description" value="${requestScope["employee"].getIdEmployee()}"></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <td>BirthDay: </td>--%>
<%--                        <td><input type="text" name="birthday" id="birthday" value="${requestScope["employee"].getBirthday()}"></td>--%>
<%--                    </tr>--%>
<%--                    <tr>--%>
<%--                        <td>gender: </td>--%>
<%--                <td>--%>
<%--                    <input type="text" name="gender" id="gender" value=<c:choose>--%>
<%--                        <c:when test="${employee.getGender()}">--%>
<%--                            Nam--%>
<%--                        </c:when>--%>
<%--                        <c:otherwise>--%>
<%--                            Nu--%>
<%--                        </c:otherwise>--%>
<%--                    </c:choose>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>Authority: </td>--%>
<%--                <td><input type="text" name="authority" id="authority" value=<c:choose>--%>
<%--                    <c:when test="${employee.getAuthority()}">--%>
<%--                        Chu--%>
<%--                    </c:when>--%>
<%--                    <c:otherwise>--%>
<%--                        NhanVien--%>
<%--                    </c:otherwise>--%>
<%--                    </c:choose>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td></td>--%>
<%--                <td><input type="submit" value="Update Employees"></td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </fieldset>--%>
<%--</form>--%>
</body>
</html>
