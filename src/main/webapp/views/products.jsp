%@ page import="com.zharnikova.example.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.zharnikova.example.model.Product" %>
<%@ page import="com.zharnikova.example.dto.ProductDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список товаров</title>
</head>
<body>
<h1>Список товаров</h1>
<table border="1">
    <thead>
    <tr>
        <th>Product Id</th>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
        <th>Stock</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<ProductDto> products = (List<ProductDto>) request.getAttribute("products");
        for (ProductDto product : products) {
    %>
    <tr>
        <td><%= product.getId() %>
        </td>
        <td><%= product.getName() %>
        </td>
        <td><%= product.getDescription() %>
        </td>
        <td><%= product.getPrice() %>
        </td>
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
