<%--
  Created by IntelliJ IDEA.
  User: ryan
  Date: 12/11/2019
  Time: 09:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/headercss.jsp" %>
    <title>Delete Table</title>
</head>
<body>
<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1>Are you sure delete this table?</h1>
        <a href="tables" class="btn btn-primary" role="button">Back to table list</a>
    </div>
</div>
<div class="container">
    <form method="post">
        <fieldset>
            <legend>Information table</legend>
            <table class="table table-striped">
                <thead>
                <tr class="alert alert-primary">
                    <th>Local:</th>
                    <th>Capacity:</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${requestScope["table"].getLocal()}</td>
                    <td>${requestScope["table"].getCapacity()}</td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" class="alert alert-danger" value="Delete"></td>
                </tr>
                </tbody>
            </table>
        </fieldset>
    </form>
</div>
</body>
</html>
