package com.uorfood.dao.implementation;

import com.uorfood.Config;
import com.uorfood.dao.ProductDao;
import com.uorfood.domain.Products;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductImplementation implements ProductDao {
    private Config config = new Config();
    private Connection coon = config.getConnection();

    private static List<Products> products;


    public ProductImplementation() throws SQLException {
    }


    @Override
    public List<Products> getAllProduct() {
        String query = "SELECT * FROM MARKET_PRODUCTS";
        products = null;
        try {
            Statement stm = coon.createStatement();
            ResultSet rest = stm.executeQuery(query);
            if (products == null) {
                products = new ArrayList<Products>();
                while (rest.next()) {
                    Products product = new Products();
                    product.setId(rest.getInt("product_id"));
                    product.setPhoto(rest.getString("product_link"));
                    product.setQuantity(rest.getInt("product_quantity"));
                    product.setTitle(rest.getString("product_title"));
                    product.setUserId(rest.getInt("user_id"));
                    product.setValidate(rest.getString("product_validate"));
                    products.add(product);
                }

            }
            coon.close();
            rest.close();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void insertProduct(Products products) {
        String query = "INSERT INTO MARKET_PRODUCTS(product_title,product_validate,product_quantity,product_link,user_id) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = coon.prepareStatement(query);
            ps.setString(1, products.getTitle());
            ps.setString(2, products.getValidate());
            ps.setInt(3, products.getQuantity());
            ps.setString(4, products.getPhoto());
            ps.setInt(5, products.getUserId());
            ps.executeQuery();
            ps.close();
            coon.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
