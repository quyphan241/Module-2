<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/22/2019
  Time: 8:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
    <form method="post" action="/translate">
        <input type="text" name="input" value="${input}">
        <input type="submit" value="Translate">
        <input type="text" name="result" value="${result}">
    </form>
</body>
</html>
