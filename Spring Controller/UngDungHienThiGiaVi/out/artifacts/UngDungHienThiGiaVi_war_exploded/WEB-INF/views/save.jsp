<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/25/2019
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
<title> Sandwich Condiments </title>
    </head>
    <body>
    <h1>Sandwich Condiments</h1>
    <c:if test = "${condiment[0].equals(check)}">
        Lectuce
    </c:if>

     <c:if test = "${condiment[1].equals(check)}">
         Tomato
     </c:if>

     <c:if test = "${condiment[2].equals(check)}">
         Mustard
     </c:if>

    <c:if test = "${condiment[3].equals(check)}">
         Sprouts
    </c:if>

    </body>
    </html>
