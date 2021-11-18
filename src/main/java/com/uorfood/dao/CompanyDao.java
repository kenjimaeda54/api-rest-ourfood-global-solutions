package com.uorfood.dao;

import com.uorfood.ddd.Company;

import java.util.List;

public interface CompanyDao {
    List<Company> getAllCompany();

    List<Company> getCompanyByEmail(String email);

    void insertCompany(Company company);

    void editCompany(Company company,Integer id);

    void deleteCompany(Integer id);


}
