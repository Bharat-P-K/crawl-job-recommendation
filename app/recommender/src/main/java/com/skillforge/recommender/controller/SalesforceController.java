package com.skillforge.recommender.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillforge.recommender.model.Candidate;
import com.skillforge.recommender.service.SalesforceService;

@RestController
public class SalesforceController {

    private final SalesforceService salesforceService;

    public SalesforceController(SalesforceService salesforceService) {
        this.salesforceService = salesforceService;
    }

    @GetMapping("/salesforce/fetchCandidatefromSalesforce")
    public List<Candidate> getCandidateFromSalesforce() {
        return salesforceService.fetchCandidatesFromSalesforce();
    }
}
