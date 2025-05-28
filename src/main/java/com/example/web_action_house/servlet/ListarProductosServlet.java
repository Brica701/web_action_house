package com.example.web_action_house.servlet;

import com.example.web_action_house.dao.CategoryDAO;
import com.example.web_action_house.dao.CategoryDAOImpl;
import com.example.web_action_house.dao.ProductDAO;
import com.example.web_action_house.dao.ProductDAOImpl;
import com.example.web_action_house.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/productos")
public class ListarProductosServlet extends HttpServlet {
    private ProductDAO productDAO = new ProductDAOImpl();
    private CategoryDAO categoryDAO = new CategoryDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userSearch = req.getParameter("searchUser");
        List<Product> productos;
        if (userSearch != null && !userSearch.trim().isEmpty()) {
            productos = productDAO.findAll();
            req.setAttribute("busquedaActiva", true);
        } else {
            productos = productDAO.findAll();
        }

        Map<String, Integer> resumen = (Map<String, Integer>) productDAO.countProductsByCategory();
        req.setAttribute("resumenCategorias", resumen);
        req.setAttribute("productos", productos);

        req.getRequestDispatcher("/WEB-INF/views/productos.jsp").forward(req, resp);
    }
}

