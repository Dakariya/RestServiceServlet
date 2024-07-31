package com.zharnikova.example.servlet;

import com.zharnikova.example.dto.CustomerProductDto;
import com.zharnikova.example.service.ProductService;
import org.junit.Before;
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
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomersProdServletTest {
    @InjectMocks
    private CustomersProdServlet servlet;

    @Mock
    private ProductService productService;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher requestDispatcher;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
     void testDoGet() throws ServletException, IOException {
        List<CustomerProductDto> customerProductDtos = Arrays.asList(new CustomerProductDto("Customer1", "Product1"));
        when(productService.getCustomerProductNamesAll()).thenReturn(customerProductDtos);
        when(request.getRequestDispatcher("views/join.jsp")).thenReturn(requestDispatcher);

        servlet.doGet(request, response);

        verify(request).setAttribute("prod", customerProductDtos);
        verify(requestDispatcher).forward(request, response);
    }
}