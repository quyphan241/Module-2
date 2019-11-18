<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ryan
  Date: 12/11/2019
  Time: 09:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/headercss.jsp" %>
    <title>Create Table</title>
</head>
<body>
<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1>Create Table</h1>
        <p><a href="tables" class="btn btn-primary" role="button">Back to table list</a></p>
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
            <label for="local">Local:</label>
            <input type="text" class="form-control" id="local" placeholder="Enter local" name="local" required>
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <div class="form-group">
            <label for="capacity">Capacity:</label>
            <input type="text" class="form-control" id="capacity" placeholder="Enter capacity" name="capacity" required>
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <button type="submit" class="btn btn-info">Create</button>
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
<%--    <form method="post">--%>
<%--        <div class="container">--%>
<%--            <table class="table table-striped">--%>
<%--                <thead>--%>
<%--                <tr class="alert alert-primary">--%>
<%--                    <td>Local</td>--%>
<%--                    <td>Capaity</td>--%>
<%--                </tr>--%>
<%--                </thead>--%>
<%--                <tbody>--%>
<%--                <tr>--%>
<%--                    <td><input type="text" name="local" id="local"></td>--%>
<%--                    <td><input type="text" name="capacity" id="capacity"></td>--%>
<%--                </tr>--%>
<%--                <tr>--%>
<%--                    <td></td>--%>
<%--                    <td><input type="submit" class="btn btn-success" value="Create"></td>--%>
<%--                </tr>--%>
<%--                </tbody>--%>
<%--            </table>--%>
<%--        </div>--%>
<%--    </form>--%>
</div>
</body>
</html>
