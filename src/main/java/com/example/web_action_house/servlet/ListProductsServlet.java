package com.example.web_action_house.servlet;

import com.example.web_action_house.dao.ProductDAO;
import com.example.web_action_house.dao.ProductDAOImpl;
import com.example.web_action_house.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/products")
public class ListProductsServlet extends HttpServlet {

    private ProductDAO productDAO;

    @Override
    public void init() {
        Connection conn = (Connection) getServletContext().getAttribute("dbConn");
        productDAO = new ProductDAOImpl(conn);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Product> products = productDAO.findAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/WEB-INF/views/products/list.jsp").forward(req, resp);
    }
}
