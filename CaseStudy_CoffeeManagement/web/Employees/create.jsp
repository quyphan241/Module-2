<%--
  Created by IntelliJ IDEA.
  User: BVMT
  Date: 12/11/2019
  Time: 1:19 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/headercss.jsp" %>
    <title>Create new employee</title>
</head>
<body>
<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1>Create New Employee</h1>
        <p>
            <a href="/employees" class="btn btn-primary" role="button">Back to Employees list</a>
        </p>
        <p>
            <c:if test='${requestScope["message"] != null}'>
                <span class="alert alert-success">${requestScope["message"]}</span>
            </c:if>
        </p>
    </div>
</div>
<div class="container">
    <form method="post" class="needs-validation" novalidate>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" placeholder="Enter local" name="name" required>
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <div class="form-group">
            <label for="price">Password:</label>
            <input type="password" class="form-control" id="price" placeholder="Enter password" name="password"
                   required>
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <input type="text" class="form-control" id="description" placeholder="Enter description"
                   name="id_card_number" required>
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <div class="form-group">
            <label for="birthday">BirthDay:</label>
            <input type="Date" class="form-control" id="birthday" name="birthday" required>
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <div class="form-group">
            <label for="gender">Gender:</label>
            <select name="gender" id="gender">
                <option selected value="true">Nam</option>
                <option value="false">Nu</option>
            </select>
        </div>
        <div class="form-group">
            <label for="authority">Authority:</label>
            <select name="authority" id="authority">
                <option selected value="true">Chu</option>
                <option value="false">NhanVien</option>
            </select>
        </div>
        <button type="submit" class="btn btn-info">Submit</button>
    </form>
    <script>
        // Disable form submissions if there are invalid fields
        (function () {
            'use strict';
            window.addEventListener('load', function () {
                // Get the forms we want to add validation styles to
                var forms = document.getElementsByClassName('needs-validation');
                // Loop over them and prevent submission
                var validation = Array.prototype.filter.call(forms, function (form) {
                    form.addEventListener('submit', function (event) {
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
<%--<div class="container">--%>
<%--    <form method="post">--%>
<%--        <table class="table table-striped">--%>
<%--            <thead>--%>
<%--            <tr class="alert alert-primary">--%>
<%--                <th>Name</th>--%>
<%--                <th>Password</th>--%>
<%--                <th>ID</th>--%>
<%--                <th>BirthDay</th>--%>
<%--                <th>Gender</th>--%>
<%--                <th>Authority</th>--%>
<%--            </tr>--%>
<%--            </thead>--%>
<%--            <tbody>--%>
<%--            <tr>--%>
<%--                <td><input type="text" name="name"></td>--%>
<%--                <td><input type="text" name="password"></td>--%>
<%--                <td><input type="text" name="id_card_number"></td>--%>
<%--                <td><input type="text" name="birthday"></td>--%>
<%--                <td><input type="text" name="gender"></td>--%>
<%--                <td><input type="text" name="authority"></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <input type="submit" class="alert alert-success" value="Create employees">--%>
<%--            </tr>--%>
<%--            </tbody>--%>

<%--        </table>--%>
<%--    </form>--%>
<%--</div>--%>
<%--</body>--%>
</html>