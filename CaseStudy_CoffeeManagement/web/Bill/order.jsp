<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: haivo1994
  Date: 14/11/2019
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Order</title>
    <%@include file="/headercss.jsp" %>
    <style>
        .add-button{
            margin: 30% auto;
        }
        .add-button_local{
            height: 100%;
            text-align: center;
        }
    </style>
</head>
<body class="body">
    <div class="main-menu">
        <p>
            <jsp:include page="/main_menu.jsp" />
        </p>
    </div>
    <div class="container show">
        <div class="row">
            <div class="col-lg-6">
                <div class="container-fluid">
                    <p>
                        <a href="/table_manager" class="btn btn btn-info">
                            Back
                        </a>
                    </p>
                </div>
                <div class="container-fluid">
                    <c:set var="total" value="${0}"/>
                    <table class="table">
                        <thead>
                        <tr class="alert alert-primary">
                            <th scope="col">Product</th>
                            <th scope="col">Price</th>
                            <th scope="col">Quantity</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${requestScope['billDetailList']}" var="detail">
                            <tr>
                                <td>${detail.getName_product()}</td>
                                <td>${detail.getPrice()}</td>
                                <td>
                                    <form method="post">
                                        <input type="number" name="quantity" value="${detail.getQuantity()}" style="width: 60%">
                                        <input type="text" name="doing" value="changeQuantity" hidden>
                                        <input type="number" name="productId"
                                               value="${detail.getProduct_id_product()}" hidden>
                                        <input type="number" name="tableId" value="${requestScope['table'].getId_table()}" hidden>
                                        <input type="number" name="billID" value="${requestScope['bill'].getId_bill()}" hidden>
                                        <input type="submit" value="Change">
                                    </form>
                                </td>
                            </tr>
                            <c:set var="total" value="${total + detail.getPrice() * detail.getQuantity()}" />
                        </c:forEach>

                            <tr class="alert alert-success">
                                <th>Total:</th>
                                <th>${total}</th>
                                <td></td>
                            </tr>
                            <tr>
                                <td>
                                <a href="/table_manager" class="btn btn-warning" role="button" style="float: left">
                                    Done
                                </a>
                            </td>
                                <td></td>
                                <td>
                                    <form method="post">
                                        <input type="text" name="doing" value="checkOutProduct" hidden>
                                        <input type="number" name="tableId" value="${requestScope['table'].getId_table()}" hidden>
                                        <input type="number" name="billID" value="${requestScope['bill'].getId_bill()}" hidden>

                                        <input type="submit" id="paybtt" class="btn btn-success" value="Pay" style="float: right;width: 100px">

                                    </form>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-lg-2">
                <div>
                    <h3>
                        <span>${requestScope["table"].getLocal()}: </span>
                        <span>${requestScope["bill"].getName_employee()}</span>
                    </h3>
                </div>
                <div class="add-button_local">
                    <input type="submit" value="ADD" class="btn btn-danger add-button" onclick="addProductIntoOrder()">
                </div>
            </div>
            <div class="col-lg-4">
                <p>
                <h3><span style="margin-left: 20px">Product Menu</span></h3>
                </p>
                <div class="container-fluid">
                    <div class="form-group">
                        <form method="post" id="addProduct">
                            <select multiple class="form-control" id="productSelect" name="productSelect">
                                <c:forEach items="${requestScope['productList']}" var="product">
                                    <option value="${product.getId()}">${product.getName()}</option>
                                </c:forEach>
                            </select>
                            <div>
                                <input type="text" name="doing" value="addProduct" hidden>
                                <input type="number" name="tableId" value="${requestScope['table'].getId_table()}" hidden>
                                <input type="number" name="billID" value="${requestScope['bill'].getId_bill()}" hidden>
<%--                                <input type="submit" value="ADD">--%>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <script>
        function addProductIntoOrder() {
            document.getElementById("addProduct").submit();

        }
    </script>
</body>
</html>
