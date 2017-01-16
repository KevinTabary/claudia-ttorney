package com.kt.claudiattorney.controller;

import com.kt.claudiattorney.entity.Case;
import com.kt.claudiattorney.entity.Customer;
import com.kt.claudiattorney.service.CaseService;
import com.kt.claudiattorney.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("case")
public class CaseController {

    private final CustomerService customerService;
    private final CaseService caseService;

    @Autowired
    public CaseController(CaseService caseService, CustomerService customerService) {
        this.caseService = caseService;
        this.customerService = customerService;
    }

    @ModelAttribute("cases")
    public List<Case> findAll() {
        return caseService.findAll();
    }

    @GetMapping("/case")
    public String getCase(Model model) {
        model.addAttribute(new Case());
        return "case";
    }

    @PostMapping("/case")
    public String create(@Valid @ModelAttribute("case") Case aCase, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "case";
        }
        caseService.save(aCase);
        model.addAttribute("cases", caseService.findAll());
        return "case";
    }

    @GetMapping(value = "/case/{customerId}/create")
    public String test(@PathVariable("customerId") Long customerId, Model model) {
        Customer customer = customerService.findOne(customerId);
        Case aCase = new Case();
        aCase.setCustomers(new ArrayList<>());
        aCase.getCustomers().add(customer);
        customer.getCases().add(aCase);
        model.addAttribute("case", aCase);
        return "case";
    }
}
