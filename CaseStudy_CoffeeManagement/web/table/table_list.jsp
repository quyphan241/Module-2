<%--
  Created by IntelliJ IDEA.
  User: haivo1994
  Date: 14/11/2019
  Time: 08:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Table Manage</title>
    <%@include file="/headercss.jsp" %>
    <link rel="stylesheet" type="text/css" href="/Support/css/table-order.css">
</head>
<body class="body">
    <div class="main-menu">
            <jsp:include page="/main_menu.jsp" />
    </div>

    <div class="container show">
        <div class="row">
            <c:forEach items="${requestScope['tables']}" var="table">
                <div class="col-lg-3 table-order show__cell">
                    <p>${table.getLocal()}</p>
                    <c:choose>
                        <c:when test="${table.getIs_available() == 0}">
                            <a href="/order_manager?idTable=${table.getId_table()}" class="btn btn-warning">
                        </c:when>
                        <c:otherwise>
                            <a href="/order_manager?idTable=${table.getId_table()}" class="btn btn-primary">
                        </c:otherwise>
                    </c:choose>
                                Order
                            </a>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
