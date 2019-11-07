<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/1/2019
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>ProductDiscountCaculator</title>
  </head>
  <body>
    <h2>Product Discount Caculator</h2>
    <form action="caculate" method="post">
      Product Description:
      <br><input type="text" name="description"><br>
      List Price:
      <br><input type="text" name="price"><br>
      Discount Percent:
      <br><input type="text" name="percent">(%)<br>
      <input type = "submit" id = "submit" value = "Caculate Discount"/>
    </form>
  </body>
</html>
