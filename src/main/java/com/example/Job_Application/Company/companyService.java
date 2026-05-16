package com.example.Job_Application.Company;

import org.springframework.stereotype.Service;

import java.util.List;

public interface companyService {

    List<Company> getAllCompanies();


    boolean updateCompany(Company company , Long id);
    void createCompany(Company company);
    boolean deleteCompanyById(Long id);
    Company getCompanyById(Long id);


}