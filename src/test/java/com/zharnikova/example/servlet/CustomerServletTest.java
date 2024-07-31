package com.zharnikova.example.servlet;

import com.zharnikova.example.dao.CustomerDao;
import com.zharnikova.example.dto.CustomerDto;
import com.zharnikova.example.model.Customer;
import com.zharnikova.example.model.Product;
import com.zharnikova.example.service.CustomerService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServletTest {
    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private CustomerService customerService;

    @Mock
    private RequestDispatcher requestDispatcher;

    @InjectMocks
    private CustomerServlet customerServlet;

    @BeforeEach
    public void setUp()   {

        MockitoAnnotations.openMocks(this);
    }

    @Test
     void testDoPost() throws ServletException, IOException {
        when(request.getParameter("name")).thenReturn("John Doe");
        when(request.getParameter("phone")).thenReturn("1234567890");
        when(request.getParameter("email")).thenReturn("john.doe@example.com");

        customerServlet.doPost(request, response);

        verify(customerService, times(1)).add(any(Customer.class));
    }


    @Test
     void testDoGetWithoutId() throws ServletException, IOException {
        List<CustomerDto> customers = Arrays.asList(new CustomerDto(), new CustomerDto());
        when(request.getParameter("id")).thenReturn(null);
        when(customerService.getAll()).thenReturn(customers);
        when(request.getRequestDispatcher("views/customers.jsp")).thenReturn(requestDispatcher);

        customerServlet.doGet(request, response);

        verify(request).setAttribute("customers", customers);
        verify(requestDispatcher).forward(request, response);
    }


    @Test
     void testDoDelete_Success() throws Exception {
        when(request.getParameter("id")).thenReturn("1");
        when(customerService.deleteCustomer(1)).thenReturn(true);

        customerServlet.doDelete(request, response);

        verify(response).setStatus(HttpServletResponse.SC_OK);
        assertTrue(true);
    }


    @Test
    void testDoPut() throws Exception {
        when(request.getParameter("id")).thenReturn("1");
        when(request.getParameter("name")).thenReturn("Test Product");
        when(request.getParameter("phone")).thenReturn("Test Phone");
        when(request.getParameter("email")).thenReturn("Test Email");

        customerServlet.doPut(request, response);

        verify(customerService, times(1)).update(any(Customer.class));
        verify(response).setStatus(HttpServletResponse.SC_OK);
    }


}