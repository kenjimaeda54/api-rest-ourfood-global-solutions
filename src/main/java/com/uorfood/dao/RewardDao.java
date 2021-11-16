package com.uorfood.dao;

import com.uorfood.domain.Reward;

import java.util.List;

public interface RewardDao {
    List<Reward> getAllReward();

    void insertReward(Reward reward);

}
