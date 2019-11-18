<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/12/2019
  Time: 9:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit product</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@include file="/headercss.jsp" %>
</head>
<body>
<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1>Edit product</h1>
        <p>
            <a href="/products" class="btn btn-primary" role="button">Back to product list</a>
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
            <input type="text" class="form-control" id="name" value="${requestScope['product'].getName()}" name="name"
                   required>
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Please fill out this field.</div>
        </div>
        <div class="form-group">
            <label for="price">Price:</label>
            <input type="text" class="form-control" id="price" value="${requestScope['product'].getPrice()}"
                   name="price" required>
            <div class="valid-feedback">Valid.</div>
            <div class="invalid-feedback">Please fill out this field.</div>
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
</body>
</html>
