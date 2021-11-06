package com.uorfood.dao.implementation;

import com.uorfood.Config;
import com.uorfood.dao.CompanyDao;
import com.uorfood.domain.Company;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyImplementation implements CompanyDao {
    private Config config = new Config();
    private Connection conn = config.getConnection();
    private static List<Company> companies;

    public CompanyImplementation() throws SQLException {
    }


    @Override
    public List<Company> getAllCompany() {
        String query = "SELECT * FROM  COMPANY";
        companies = null;
        try {
            Statement stm = conn.createStatement();
            ResultSet rst = stm.executeQuery(query);
            if (companies == null) {
                companies = new ArrayList<Company>();
                while (rst.next()) {
                    Company company = new Company();
                    company.setName(rst.getString("company_name"));
                    company.setLocation(rst.getString("company_location"));
                    company.setDonation(rst.getInt("company_donation"));
                    company.setPhoto(rst.getString("company_link"));
                    company.setId(rst.getInt("company_id"));
                    company.setUserId(rst.getInt("user_id"));
                    companies.add(company);
                }
            }
            conn.close();
            rst.close();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companies;
    }

    @Override
    public List<Company> getCompanyById(Integer id) {
        String query = "SELECT * FROM COMPANY";
        companies = null;
        try {
            Statement stm = conn.createStatement();
            ResultSet rst = stm.executeQuery(query);
            if (companies == null) {
                companies = new ArrayList<Company>();
                while (rst.next()) {
                    Company company = new Company();
                    if (id.equals(rst.getInt("company_id"))) {
                        company.setUserId(rst.getInt("user_id"));
                        company.setDonation(rst.getInt("company_donation"));
                        company.setId(rst.getInt("company_id"));
                        company.setName(rst.getString("company_name"));
                        company.setPhoto(rst.getString("company_link"));
                        company.setLocation(rst.getString("company_location"));
                        companies.add(company);
                        conn.close();
                        rst.close();
                        stm.close();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companies;
    }

    @Override
    public void insertCompany(Company company) {
        String query = "INSERT INTO COMPANY (company_name,company_donation,company_link,company_location,user_id) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, company.getName());
            ps.setInt(2, company.getDonation());
            ps.setString(3, company.getPhoto());
            ps.setString(4, company.getLocation());
            ps.setInt(5, company.getUserId());
            ps.executeQuery();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editCompany(Company company, Integer id) {
        String query = "UPDATE company SET company_name=?,company_location=?,company_link=?,company_donation=? WHERE user_id=? AND company_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, company.getName());
            ps.setString(2, company.getLocation());
            ps.setString(3, company.getPhoto());
            ps.setInt(4, company.getDonation());
            ps.setInt(5, company.getUserId());
            ps.setInt(6, id);
            ps.executeQuery();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCompany(Integer id) {
        String query = "DELETE FROM company WHERE company_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeQuery();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
