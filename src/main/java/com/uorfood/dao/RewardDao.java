package com.uorfood.dao;

import com.uorfood.ddd.Reward;

import java.util.List;

public interface RewardDao {
    List<Reward> getAllReward();

    void insertReward(Reward reward);

}
