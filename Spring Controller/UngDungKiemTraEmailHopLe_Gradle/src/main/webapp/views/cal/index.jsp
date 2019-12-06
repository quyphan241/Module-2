<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/27/2019
  Time: 9:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
    <form method="post">
        <input type="text" name="input1" value="${input1}">
        <input type="text" name="input2" value="${input2}"> <br>
        <input type="submit" value="Addition(+)" formaction="add">
        <input type="submit" value="Subtraction(-)" formaction="sub">
        <input type="submit" value="Multiplication(*)" formaction="multi">
        <input type="submit" value="Division(/)" formaction="div">
    </form>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</body>
</html>
