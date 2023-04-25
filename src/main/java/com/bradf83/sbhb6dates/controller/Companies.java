package com.bradf83.sbhb6dates.controller;

import java.time.Instant;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bradf83.sbhb6dates.model.Company;
import com.bradf83.sbhb6dates.repository.CompanyRepository;

@RestController
@RequestMapping(path = "/companies")
public class Companies {

    private final CompanyRepository companyRepository;

    public Companies(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping
    public List<Company> list() {
        return this.companyRepository.findAll();
    }

    // Get should not be creating data, just something quick and dirty.
    @GetMapping("/create")
    public String create() {

        Instant now = Instant.now();

        Company company = new Company();
        company.setName("Test" + now);
        company.setCreationDate(now);
        company.setCreationDateTz(now);

        this.companyRepository.save(company);

        return "Created";
    }
}
