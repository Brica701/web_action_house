package com.example.web_action_house.servlet;

import com.example.web_action_house.dao.AuctionDAO;
import com.example.web_action_house.dao.AuctionDAOImpl;
import com.example.web_action_house.model.Auction;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;

public class EditAuctionServlet extends HttpServlet {

    private AuctionDAO auctionDAO;

    @Override
    public void init() {
        Connection conn = (Connection) getServletContext().getAttribute("dbConn");
        auctionDAO = new AuctionDAOImpl(conn);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int auctionId = Integer.parseInt(req.getParameter("id"));
        Auction auction = auctionDAO.findById(auctionId);
        req.setAttribute("auction", auction);
        req.getRequestDispatcher("/WEB-INF/views/auctions/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int auctionId = Integer.parseInt(req.getParameter("auctionId"));
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");

        Auction auction = new Auction();
        auction.setAuctionId(auctionId);
        auction.setStartDate(Date.valueOf(startDate));
        auction.setEndDate(Date.valueOf(endDate));

        auctionDAO.update(auction);
        resp.sendRedirect(req.getContextPath() + "/auctions");
    }
}

