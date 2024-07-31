package com.zharnikova.example.servlet;

import com.mysql.cj.util.StringUtils;
import com.zharnikova.example.dto.CustomerDto;
import com.zharnikova.example.dto.ProductDto;
import com.zharnikova.example.mapper.ProductMapper;
import com.zharnikova.example.model.Customer;
import com.zharnikova.example.model.Product;
import com.zharnikova.example.service.CustomerService;
import com.zharnikova.example.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/products/*")
public class ProductServlet extends HttpServlet {

    private ProductService productService;

    @Override
    public void init() throws ServletException {
        super.init();
        productService = new ProductService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Double price = Double.valueOf(req.getParameter("price"));
        Integer stock = Integer.valueOf(req.getParameter("stock"));
        Product newproduct = new Product(name, description, price, stock);
        productService.add(newproduct);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        if (!StringUtils.isNullOrEmpty(id)) {
            req.setAttribute("product", getById(id));

            req.getRequestDispatcher("views/product.jsp").forward(req, resp);
        } else {
            List<ProductDto> productDtos = productService.getAll();

            req.setAttribute("products", productDtos);

            req.getRequestDispatcher("views/products.jsp").forward(req, resp);
        }
    }


    private void update(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Double price = Double.valueOf(req.getParameter("price"));
        Integer stock = Integer.valueOf(req.getParameter("stock"));
        Product product = new Product(id, name, description, price, stock);
        productService.update(product);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    private ProductDto getById(String idStr) {
        int id = Integer.parseInt(idStr);
        return ProductMapper.mapToProductDto(productService.getById(id).get());//return DTO
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        productService.delete(id);
        resp.setStatus(HttpServletResponse.SC_OK);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            update(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}


