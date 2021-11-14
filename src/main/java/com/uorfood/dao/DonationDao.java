package com.uorfood.dao;

import com.uorfood.domain.Donation;

import java.util.List;

public interface DonationDao {
    List<Donation> getAllDonation();

    void updateDonation(Donation donation,Integer id);

    List<Donation>  getById(Integer id);

}
