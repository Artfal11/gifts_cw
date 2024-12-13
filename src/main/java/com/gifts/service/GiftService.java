package com.gifts.service;

import com.gifts.model.Gift;
import com.gifts.repository.GiftRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GiftService {
    private GiftRepository giftRepository = new GiftRepository();

    public List<Gift> getAllGifts() throws SQLException {
        return giftRepository.findAll();
    }

    public Gift getGiftById(int id) throws SQLException {
        return giftRepository.findById(id);
    }
}
