<%@ page import="com.zharnikova.example.model.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="com.zharnikova.example.dto.CustomerDto" %>
<%@ page import="com.zharnikova.example.dto.ProductDto" %>
<%@ page import="com.zharnikova.example.model.Product" %>
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
        ProductDto product = (ProductDto) request.getAttribute("product");{
    %>
    <tr>
        <td><%= product.getId() %>
        </td>
        <td><%= product.getName() %>
        </td>
        <td><%= product.getDescription() %>
        </td>
        <td><%= product.getPrice() %>

        <td><%= product.getStock() %>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>