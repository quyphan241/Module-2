<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PhanAnhVu
  Date: 11/11/2019
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>

    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="Support/css/login.css"/>

</head>
<body>
<div class="main">
    <div class="image">
        <img src="https://dailycoffeenews.com/wp-content/uploads/2018/10/coffee-801781_1280.jpg" class="rounded"
             alt="coffee-image" style="width: 100%;height: 100%;opacity: 0.7">
    </div>
    <div class="login-main">
        <form method="post" action="login" id="login">
            <div class="login">
                <div class="jumbotron jumbotron-fluid">
                    <div class="container">
                        <div style="text-align: center;"><h1>Coffee Shop</h1></div>
                    </div>
                </div>
                <div class="login__row">
                    <div class="login__cell_left">Id</div>
                    <div class="login__cell_right">
                        <input type="number" name="id_employee" id="id_employee">
                    </div>
                </div>
                <div class="login__row">
                    <div class="login__cell_left">Password</div>
                    <div class="login__cell_right">
                        <input type="password" name="password_id_employee" id="password_id_employee">
                    </div>
                </div>
                <div class="login__row">
                    <div class="login__cell_left"><p></p></div>
                    <div class="login__cell_right">
                        <input type="submit" class="btn btn-info" value="Đăng Nhập" style="text-align: center">
                        <c:if
                                test="${sessionScope['login_info']==null}">
                            <span>${requestScope['messenger']}</span>
                        </c:if>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
