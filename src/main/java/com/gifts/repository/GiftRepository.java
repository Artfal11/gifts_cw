package com.gifts.repository;

import com.gifts.model.Gift;
import com.gifts.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GiftRepository {

    public List<Gift> findAll() throws SQLException {
        List<Gift> gifts = new ArrayList<>();
        String sql = "SELECT * FROM gifts";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Gift gift = new Gift();
                gift.setId(rs.getInt("id"));
                gift.setTitle(rs.getString("title"));
                gift.setGiverName(rs.getString("giver_name"));
                gift.setReceiverName(rs.getString("receiver_name"));
                gift.setDeliveryDate(rs.getDate("delivery_date"));
                gifts.add(gift);
            }
        }
        return gifts;
    }

    public Gift findById(int id) throws SQLException {
        Gift gift = null;
        String sql = "SELECT * FROM gifts WHERE id = ?";
        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    gift = new Gift();
                    gift.setId(rs.getInt("id"));
                    gift.setTitle(rs.getString("title"));
                    gift.setGiverName(rs.getString("giver_name"));
                    gift.setReceiverName(rs.getString("receiver_name"));
                    gift.setDeliveryDate(rs.getDate("delivery_date"));
                }
            }
        }
        return gift;
    }
}
