<%@ page import="com.zharnikova.example.model.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="com.zharnikova.example.dto.CustomerDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список заказчиков</title>
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
        List<CustomerDto> customers = (List<CustomerDto>) request.getAttribute("customers");
        for (CustomerDto customer : customers) {
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