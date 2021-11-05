package com.uorfood.dao;

import com.uorfood.domain.Users;

import java.util.List;

public  interface UserDao {
    List<Users>  getUsersAll();
    void         insertUsers(Users users);


}
