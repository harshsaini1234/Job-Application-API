package com.example.Job_Application.Company.imp;

import com.example.Job_Application.Company.Company;
import com.example.Job_Application.Company.companyRepository;
import com.example.Job_Application.Company.companyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class companyServiceImp implements companyService {

    private companyRepository companyrepository;

    public companyServiceImp(companyRepository companyrepository) {
        this.companyrepository = companyrepository;
    }

    @Override
    public List<Company> getAllCompanies(){
        return companyrepository.findAll();
    }

//    @Override
//    public boolean updatedCompany(Company company, Long id) {
//        Optional<Company> companyOptional =companyrepository.findById(id);
//
//        if (companyOptional.isPresent()){
//            Company companyToUpdate = companyOptional.get();
//            companyToUpdate.setDescription(companyToUpdate.getDescription());
//            companyToUpdate.setName(companyToUpdate.getName());
//            companyToUpdate.setJobs(company.getJobs());
//            companyrepository.save(companyToUpdate);
//            return true;
//        } else {
//            return false;
//        }

    }


}
