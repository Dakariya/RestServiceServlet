package com.zharnikova.example.servlet;

import com.zharnikova.example.dto.ProductDto;
import com.zharnikova.example.repository.ProductRepository;
import com.zharnikova.example.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cp/*")
public class CustomersProductsServlet extends HttpServlet {

    private ProductService productService;
    @Override
    public void init() throws ServletException {
        super.init();
        productService = new ProductService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        ProductDto productDto=productService.getProductWitsCustomers(Integer.valueOf(id));
        req.setAttribute("productscustomers", productDto);

        req.getRequestDispatcher("views/productscustomers.jsp").forward(req, resp);
    }
}
