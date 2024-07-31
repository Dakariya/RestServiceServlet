package com.zharnikova.example.servlet;


import com.mysql.cj.util.StringUtils;
import com.zharnikova.example.dao.CustomerDao;
import com.zharnikova.example.dto.CustomerDto;
import com.zharnikova.example.mapper.CustomerMapper;
import com.zharnikova.example.mapper.ProductMapper;
import com.zharnikova.example.model.Customer;
import com.zharnikova.example.service.CustomerService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

@WebServlet("/customers/*")
public class CustomerServlet extends HttpServlet {


    private CustomerService customerService;

        @Override
    public void init() throws ServletException {
        super.init();
        customerService = (CustomerService) getServletContext().getAttribute("customerService");
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        Customer newcustomer = new Customer(name, phone, email);
        customerService.add(newcustomer);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        if (!StringUtils.isNullOrEmpty(id)) {
            req.setAttribute("customer", getById(id));

            req.getRequestDispatcher("views/customer.jsp").forward(req, resp);
        } else {
            List<CustomerDto> customerDtos = customerService.getAll();

            req.setAttribute("customers", customerDtos);

            req.getRequestDispatcher("views/customers.jsp").forward(req, resp);
        }
    }


    private void update(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");

        Customer customer = new Customer(id, name, phone, email);
        customerService.update(customer);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    private CustomerDto getById(String idStr) {
        int id = Integer.parseInt(idStr);
        return CustomerMapper.mapToCustomerDto(customerService.getById(id).get());
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        customerService.deleteCustomer(id);
        resp.setStatus(HttpServletResponse.SC_OK);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            update(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}








