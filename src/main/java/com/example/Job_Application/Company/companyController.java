package com.example.Job_Application.Company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class companyController {
    private companyService companyservice;

    public companyController(companyService companyservice) {
        this.companyservice = companyservice;
    }

    @GetMapping
    public List<Company> getAllCompanies(){
        return companyservice.getAllCompanies();
    }

//    @PutMapping
//    public ResponseEntity<String> updateCompany(@PathVariable Long id ,
//                                                @RequestBody Company company){
//        companyService.updatedCompany(company, id);
//        return new ResponseEntity<>("Company updated successfully", HttpStatus.OK);
//
//    }
}
