package com.kt.claudiattorney.controller;

import com.kt.claudiattorney.entity.Case;
import com.kt.claudiattorney.entity.Customer;
import com.kt.claudiattorney.repository.CaseRepository;
import com.kt.claudiattorney.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@SessionAttributes("customer")
public class CustomerController {

    private final CaseRepository caseRepository;
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService, CaseRepository caseRepository) {
        this.customerService = customerService;
        this.caseRepository = caseRepository;
    }

    @GetMapping("/customer")
    public String createCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customers", customerService.findAll());
        return "customer";
    }

    @PostMapping("/customer")
    public String createCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "customer";
        }
        customerService.save(customer);
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("customer", new Customer());
        return "customer";
    }


    @GetMapping(value = "/customer/{caseId}/create")
    public String test(@PathVariable("caseId") Long caseId, Model model) {
        Case aCase = caseRepository.findOne(caseId);
        Customer customer = new Customer();
        customer.getCases().add(aCase);
        model.addAttribute("customer", customer);
        model.addAttribute("customers", customerService.findAll());
        return "customer";
    }

}
