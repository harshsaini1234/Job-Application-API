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
    public ResponseEntity<List<Company>> getAllCompanies(){
        return new ResponseEntity<>(companyservice.getAllCompanies(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id,
                                                @RequestBody Company company)
    {
        companyservice.updateCompany(company,id);
        return new ResponseEntity<>("Company updated successfully ",HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> addCompany(@RequestBody Company company)
    {
        companyservice.createCompany(company);
        return new ResponseEntity<>("Company successfully added",HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        boolean isDeleted = companyservice.deleteCompanyById(id);
        if (isDeleted) {
            return new ResponseEntity<>("company deleted successfully ", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("company not fund",HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id){
        Company company = companyservice.getCompanyById(id);
        if (company!=null){
            return new ResponseEntity<>(company,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
