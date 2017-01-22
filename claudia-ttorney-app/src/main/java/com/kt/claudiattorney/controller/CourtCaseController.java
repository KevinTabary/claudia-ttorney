package com.kt.claudiattorney.controller;

import com.kt.claudiattorney.entity.CourtCase;
import com.kt.claudiattorney.entity.Customer;
import com.kt.claudiattorney.repository.CourtCaseRepository;
import com.kt.claudiattorney.service.CaseService;
import com.kt.claudiattorney.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
//@SessionAttributes("case")
public class CourtCaseController {

    private final CustomerService customerService;
    private final CaseService caseService;
    private final CourtCaseRepository courtCaseRepository;

    @Autowired
    public CourtCaseController(CaseService caseService, CustomerService customerService, CourtCaseRepository courtCaseRepository) {
        this.caseService = caseService;
        this.customerService = customerService;
        this.courtCaseRepository = courtCaseRepository;
    }

    @GetMapping("/case")
    public String getCase(Model model) {
        model.addAttribute("case", new CourtCase());
        model.addAttribute("cases", caseService.findAll());
        return "case";
    }

    @PostMapping("/case")
    public String create(@Valid @ModelAttribute("case") CourtCase courtCase, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "case";
        }
        courtCaseRepository.save(courtCase);
        model.addAttribute("cases", caseService.findAll());
        model.addAttribute("case", new CourtCase());
        return "case";
    }

    @GetMapping(value = "/case/{customerId}/create")
    public String initAddCaseToCustomer(@PathVariable("customerId") Long customerId, Model model) {
        model.addAttribute("case", new CourtCase());
        model.addAttribute("cases", caseService.findAll());
        model.addAttribute("customerId", customerId);
        return "add_case_to_customer";
    }

    @PostMapping(value = "/case/add/customer/{customerId}")
    public String processAddCaseToCustomer(@PathVariable("customerId") Long customerId, @ModelAttribute("case") CourtCase courtCase, Model model) {
        Customer customer = customerService.findOne(customerId);
        courtCase.getCustomers().add(customer);
        customer.getCourtCases().add(courtCase);
        courtCaseRepository.save(courtCase);
        model.addAttribute("case", new CourtCase());
        model.addAttribute("cases", caseService.findAll());
        return "case";
    }
}
