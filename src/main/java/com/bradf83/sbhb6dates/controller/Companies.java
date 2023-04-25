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

    @GetMapping("/create")
    public String create() {

        Instant now = Instant.now();

        Company comp = new Company();
        comp.setName("Test" + now);
        comp.setCreationDate(now);
        comp.setCreationDateTz(now);

        this.companyRepository.save(comp);

        return "Created";
    }

    /**
     * System Time
     * {
     * "name": "Test2023-04-25T01:16:36.385523300Z",
     * "creationDate": "2023-04-24T19:16:36.385523Z",
     * "creationDateTz": "2023-04-25T01:16:36.385523Z"
     * }
     * 
     * Setting TimeZone.default to UTC on Startup in Application.java (DOES NOT SEEM
     * TO WORK ANYMORE)
     * "name": "Test2023-04-25T01:21:48.072176100Z",
     * "creationDate": "2023-04-24T19:21:48.072176Z",
     * "creationDateTz": "2023-04-25T01:21:48.072176Z"
     * 
     * Setting Time Zone for the app using a JVM Argument
     * "name": "Test2023-04-25T01:42:13.717011600Z",
     * "creationDate": "2023-04-25T01:42:13.717012Z",
     * "creationDateTz": "2023-04-25T01:42:13.717012Z"
     */
}
