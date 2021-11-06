package com.uorfood.dao;

import com.uorfood.domain.Company;

import java.util.List;

public interface CompanyDao {
    List<Company> getAllCompany();

    List<Company> getCompanyById(Integer id);

    void insertCompany(Company company);

    void editCompany(Company company,Integer id);

    void deleteCompany(Integer id);


}
