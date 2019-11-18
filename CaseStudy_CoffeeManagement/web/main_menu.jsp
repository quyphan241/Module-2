<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: haivo1994
  Date: 14/11/2019
  Time: 09:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark ">

        <a class="navbar-brand" href="/table_manager">Manage</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="/products">Product<span class="sr-only">(current)</span></a>
                </li>
                <c:choose>
                    <c:when test="${sessionScope['login_info'].getAuthority()>0}">
                        <li class="nav-item">
                            <a class="nav-link" href="/employees">Employee</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link disabled" href="/employees" tabindex="-1" aria-disabled="true">Employee</a>
                        </li>
                    </c:otherwise>
                </c:choose>
                <li class="nav-item">
                    <a class="nav-link" href="/bills">Bills</a>
                </li>
                <c:choose>
                    <c:when test="${sessionScope['login_info'].getAuthority()>0}">
                        <li class="nav-item">
                            <a class="nav-link" href="/tables">Table</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link disabled" href="/tables" tabindex="-1" aria-disabled="true">Table</a>
                        </li>
                    </c:otherwise>
                </c:choose>
                <li class="nav-item">
                    <a class="nav-link" href="/login?doing=logout">Hello, ${sessionScope['login_info'].getName()}</a>
                </li>
            </ul>
        </div>
    </nav>
</div>

