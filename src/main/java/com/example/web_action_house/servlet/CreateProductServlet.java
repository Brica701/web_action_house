package com.example.web_action_house.servlet;

import com.example.web_action_house.dao.ProductDAO;
import com.example.web_action_house.dao.ProductDAOImpl;
import com.example.web_action_house.dao.CategoryDAO;
import com.example.web_action_house.dao.CategoryDAOImpl;
import com.example.web_action_house.dao.AuctionDAO;
import com.example.web_action_house.dao.AuctionDAOImpl;
import com.example.web_action_house.model.Auction;
import com.example.web_action_house.model.Category;
import com.example.web_action_house.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/products/create")
public class CreateProductServlet extends HttpServlet {

    private ProductDAO productDAO;
    private CategoryDAO categoryDAO;
    private AuctionDAO auctionDAO;

    @Override
    public void init() {
        Connection conn = (Connection) getServletContext().getAttribute("dbConn");
        productDAO = new ProductDAOImpl(conn);
        categoryDAO = new CategoryDAOImpl(conn);
        auctionDAO = new AuctionDAOImpl(conn);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryDAO.findAll();
        List<Auction> auctions = auctionDAO.findAll();
        req.setAttribute("categories", categories);
        req.setAttribute("auctions", auctions);
        req.getRequestDispatcher("/WEB-INF/views/products/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String imgUrl = req.getParameter("img_url");
        double startingBid = Double.parseDouble(req.getParameter("starting_bid"));
        double currentBid = Double.parseDouble(req.getParameter("current_bid"));
        double closingBid = Double.parseDouble(req.getParameter("closing_bid"));
        int categoryId = Integer.parseInt(req.getParameter("category_id"));
        int auctionId = Integer.parseInt(req.getParameter("auction_id"));

        Category category = new Category();
        category.setCategoryId(categoryId);

        Auction auction = new Auction();
        auction.setAuctionId(auctionId);

        Product product = new Product(title, description, imgUrl, startingBid, currentBid, closingBid, category, auction);

        productDAO.save(product);
        resp.sendRedirect(req.getContextPath() + "/products");
    }
}

