package com.zharnikova.example.servlet;

import com.zharnikova.example.dto.ProductDto;
import com.zharnikova.example.model.Product;
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
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServletTest {
    @InjectMocks
    private ProductServlet servlet;

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
     void testDoPost() throws ServletException, IOException {
        when(request.getParameter("name")).thenReturn("Test Product");
        when(request.getParameter("description")).thenReturn("Test Description");
        when(request.getParameter("price")).thenReturn("99.99");
        when(request.getParameter("stock")).thenReturn("10");

        servlet.doPost(request, response);

        verify(productService).add(any(Product.class));
    }


    @Test
     void testDoGetWithoutId() throws ServletException, IOException {
        when(request.getParameter("id")).thenReturn(null);
        List<ProductDto> productDtos = Arrays.asList(new ProductDto(1,"Test Product", "Test Description", 99.99, 10));
        when(productService.getAll()).thenReturn(productDtos);
        when(request.getRequestDispatcher("views/products.jsp")).thenReturn(requestDispatcher);

        servlet.doGet(request, response);

        verify(request).setAttribute("products", productDtos);
        verify(requestDispatcher).forward(request, response);
    }

    @Test
     void testDoPut() throws Exception {
        when(request.getParameter("id")).thenReturn("1");
        when(request.getParameter("name")).thenReturn("Test Product");
        when(request.getParameter("description")).thenReturn("Test Description");
        when(request.getParameter("price")).thenReturn("99.99");
        when(request.getParameter("stock")).thenReturn("10");

        servlet.doPut(request, response);

        verify(productService, times(1)).update(any(Product.class));
        verify(response).setStatus(HttpServletResponse.SC_OK);
    }
    @Test
     void testDoDelete() throws Exception {
        when(request.getParameter("id")).thenReturn("1");

        servlet.doDelete(request, response);

        verify(productService, times(1)).delete(1);
        verify(response).setStatus(HttpServletResponse.SC_OK);
    }


}