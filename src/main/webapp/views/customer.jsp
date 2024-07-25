<%@ page import="com.zharnikova.example.model.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="com.zharnikova.example.dto.CustomerDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer</title>
</head>
<body>
<h1>Список заказчиков</h1>
<table border="1">
    <thead>
    <tr>
        <th>User Id</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <%
        CustomerDto customer = (CustomerDto) request.getAttribute("customer");{
    %>
    <tr>
        <td><%= customer.getId() %>
        </td>
        <td><%= customer.getName() %>
        </td>
        <td><%= customer.getPhone() %>
        </td>
        <td><%= customer.getEmail() %>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
