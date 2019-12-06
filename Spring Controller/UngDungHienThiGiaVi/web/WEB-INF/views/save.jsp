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
<%--    <c:if test = "${condiments[0]!=null}">--%>
<%--        ${condiments[0]}--%>
<%--    </c:if>--%>

<%--     <c:if test = "${condiments[1]!=null}">--%>
<%--         ${condiments[1]}--%>
<%--     </c:if>--%>

<%--     <c:if test = "${condiments[2]!=null}">--%>
<%--         ${condiments[2]}--%>
<%--     </c:if>--%>

<%--    <c:if test = "${condiments[3]!=null}">--%>
<%--         ${condiments[3]}--%>
<%--    </c:if><br>--%>
    <c:forEach var="condiment" items="${condiments}">
        <h3><c:out value = "${condiment}" /></h3><br>
    </c:forEach>
    </body>
    </html>
