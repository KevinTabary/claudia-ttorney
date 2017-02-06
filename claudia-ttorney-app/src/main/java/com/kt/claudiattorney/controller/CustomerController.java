package com.kt.claudiattorney.controller;

import com.kt.claudiattorney.dto.CustomerForm;
import com.kt.claudiattorney.entity.CourtCase;
import com.kt.claudiattorney.entity.Customer;
import com.kt.claudiattorney.repository.CourtCaseRepository;
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
public class CustomerController {

    private final CourtCaseRepository courtCaseRepository;
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService, CourtCaseRepository courtCaseRepository) {
        this.customerService = customerService;
        this.courtCaseRepository = courtCaseRepository;
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

    @PostMapping("/deleteCustomer")
    public String deleteCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult errors, Model model) {
        if (errors.hasErrors()) {
            return "customer";
        }
        customerService.deleteCustomer(customer);
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("customer", new Customer());
        return "customer";
    }

    @GetMapping(value = "/customer/{caseId}/create")
    public String test(@PathVariable("caseId") Long caseId, Model model) {
        CourtCase courtCase = courtCaseRepository.findOne(caseId);
        Customer customer = new Customer();
        customer.getCourtCases().add(courtCase);
        courtCase.getCustomers().add(customer);
        model.addAttribute("customer", customer);
        model.addAttribute("customers", customerService.findAll());
        return "customer";
    }

    @GetMapping(value = "/customer/add/{caseId}")
    public String getPopUp(Model model, @PathVariable("caseId") Long caseId) {
        model.addAttribute("customers", customerService.findAllCustomersNotInCase(caseId));
        model.addAttribute("customerForm", new CustomerForm());
        model.addAttribute("caseId", caseId);
        return "add_customer_to_case";
    }

    @PostMapping(value = "/customer/case/add/{caseId}")
    public String addCustomersToCase(@PathVariable("caseId") Long caseId, @ModelAttribute("customerForm") CustomerForm customerForm, Model model) {
        CourtCase courtCase = courtCaseRepository.findOne(caseId);
        courtCase.getCustomers().addAll(customerForm.getCustomers());
        customerForm.getCustomers().forEach(customer -> customer.getCourtCases().add(courtCase));
        courtCaseRepository.save(courtCase);
        model.addAttribute("case", new CourtCase());
        model.addAttribute("cases", courtCaseRepository.findAll());
        return "case";
    }
}
