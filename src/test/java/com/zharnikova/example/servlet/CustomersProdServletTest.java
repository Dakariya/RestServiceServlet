package com.zharnikova.example.servlet;


import com.zharnikova.example.dto.CustomerProductDto;

import com.zharnikova.example.service.ProductService;
import org.apache.struts.mock.MockHttpServletRequest;
import org.apache.struts.mock.MockHttpServletResponse;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CustomersProdServletTest {

 @Mock
 HttpServletRequest req;
 HttpServletResponse resp;
 ProductService productService;
 @Test
 void doGet()   {
 }

 private CustomersProdServlet servlet;


 @Test
  void testDoGet() throws Exception {



 }


}