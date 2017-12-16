<%@ page import="ua.kiev.prog.SaveDataServlet" %><%--
  Created by IntelliJ IDEA.
  User: Guantanamo
  Date: 14-Dec-17
  Time: 0:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Statistics</title>
</head>
<body>
<h1>Thx for making our bright and shine test!<br/> Good luck mate!</h1>

<ul>
    <table border="1">
        <tr>
            <td colspan="2">Choose the pill<br/></td>
            <td colspan="2">U like coffee?<br/></td>
            <td colspan="2">R U MAD?!<br/></td>
        </tr>
        <tr>
            <td>Blue</td>
            <td>Red</td>
            <td>Yes</td>
            <td>No</td>
            <td>Yes</td>
            <td>No</td>
        </tr>
        <tr>
            <td><%= SaveDataServlet.getqOneBlue() %></td>
            <td><%= SaveDataServlet.getqOneRed() %></td>
            <td><%= SaveDataServlet.getqTwoYes() %></td>
            <td><%= SaveDataServlet.getqTwoNo() %></td>
            <td><%= SaveDataServlet.getqThreeYes() %></td>
            <td><%= SaveDataServlet.getqThreeNo() %></td>
        </tr>
    </table>
</ul>
<h3>Get back to the <a href = "test.jsp">test</a>, bro!</h3>
<br>Click this link to <a href="/login?a=exit">logout</a>

</body>
</html>
