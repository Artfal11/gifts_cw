package com.gifts.controller;

import com.gifts.model.Gift;
import com.gifts.service.GiftService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("")
public class GiftController extends HttpServlet {
    private final GiftService giftService = new GiftService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Gift> gifts = giftService.getAllGifts();
            request.setAttribute("gifts", gifts);
            request.getRequestDispatcher("/gifts.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
