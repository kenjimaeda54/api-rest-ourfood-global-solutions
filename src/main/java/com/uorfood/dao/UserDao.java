package com.uorfood.dao;

import com.uorfood.domain.Users;

import java.util.List;

public interface UserDao {
    List<Users> getUsersAll();

    List<Users> getUserById(Integer id);

    List<Users> getUserByEmail(String email);

    void insertUsers(Users users);

    void editUsers(Users users,Integer id);

    void deleteUser(Integer id);

}
