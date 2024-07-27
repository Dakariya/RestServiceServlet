%@ page import="com.zharnikova.example.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.List" %>
<%@ page import="com.zharnikova.example.dto.CustomerProductDto" %>
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
        List<CustomerProductDto> customerProductDtos = (List<CustomerProductDto>) request.getAttribute("prod");
        for (CustomerProductDto customerProductDto : customerProductDtos) {
    %>
    <tr>
        <td><%= customerProductDto.getCustomer_name() %>
        </td>
        <td><%= customerProductDto.getProduct_name() %>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>