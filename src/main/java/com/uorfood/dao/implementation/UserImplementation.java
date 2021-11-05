package com.uorfood.dao.implementation;



import com.uorfood.Config;
import com.uorfood.dao.UserDao;
import com.uorfood.domain.Users;

import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserImplementation implements UserDao {
    private Config config = new Config();
    private static List<Users> users;
    private Connection coon = config.getConnection();

    public UserImplementation() throws SQLException {

    }
    @Override
    public List<Users> getUsersAll() {
        String query = "SELECT * FROM USERS";
        users = null;
        try {
            Statement stm = coon.createStatement();
            ResultSet rst = stm.executeQuery(query);
            if (users == null) {
                users = new ArrayList<Users>();
                while (rst.next()) {
                    Users setUsers = new Users();
                    setUsers.setId(rst.getInt("user_id"));
                    setUsers.setPassword(rst.getString("user_password"));
                    setUsers.setDonation(rst.getInt("user_donation"));
                    setUsers.setName(rst.getString("user_name"));
                    setUsers.setPunctuation(rst.getInt("user_punctuation"));
                    setUsers.setEmail(rst.getString("user_email"));
                    users.add(setUsers);
                }

            }
            rst.close();
            coon.close();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void insertUsers(Users users) {
        String query = "INSERT INTO USERS(user_email,user_name,user_password,user_punctuation,user_donation) VALUES(?,?,?,?,?) ";
        try {
            PreparedStatement ps = coon.prepareStatement(query);
            ps.setString(1,users.getEmail());
            ps.setString(2,users.getName());
            ps.setString(3,users.getPassword());
            ps.setInt(4,users.getPunctuation());
            ps.setInt(5,users.getDonation());
            ps.executeQuery();
            ps.close();
            coon.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


