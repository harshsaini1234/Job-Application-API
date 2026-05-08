package com.example.Job_Application.Company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface companyRepository extends JpaRepository<Company,Long> {
}
