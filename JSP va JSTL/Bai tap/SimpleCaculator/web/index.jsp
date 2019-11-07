<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/4/2019
  Time: 7:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Simple Calculator</title>
  </head>
  <body>
  <h1>Simple Calculator</h1>
  <form method="post" action="calculate">
  <table>
    <tr>
      <td>First operand: </td>
      <td><input type="text" name="firstOperand"></td>
    </tr>
    <tr>
      <td>Operator:</td>
      <td>
        <select name="operator">
        <option value="+">Addition</option>
        <option value="-">Subtraction</option>
        <option value="*">Multiplication</option>
        <option value="/">Division</option>
        </select>
      </td>
    </tr>
    <tr>
      <td>Second operand: </td>
      <td><input type="text" name="secondOperand"></td>
    </tr>
    <tr>
      <td></td>
      <td><input type="submit" id="submit" value="Calculate"></td>
    </tr>
  </table>
  </form>
  </body>
</html>
