package com.example.Job_Application.Company;

import org.springframework.stereotype.Service;

import java.util.List;

public interface companyService {

    List<Company> getAllCompanies();

//    boolean updatedCompany(Company company, Long id);
}