package com.zharnikova.example.servlet;

import com.zharnikova.example.dto.CustomerProductDto;
import com.zharnikova.example.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/join")
public class CustomersProdServlet extends HttpServlet{

        private ProductService productService;
        @Override
        public void init() throws ServletException {
            super.init();
            productService = new ProductService();
        }
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            List<CustomerProductDto> customerProductDtos = productService.getCustomerProductNamesAll();

            req.setAttribute("prod", customerProductDtos);

            req.getRequestDispatcher("views/join.jsp").forward(req, resp);
        }

}

