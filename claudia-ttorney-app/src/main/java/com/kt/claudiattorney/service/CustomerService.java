package com.kt.claudiattorney.service;

import com.kt.claudiattorney.entity.CourtCase;
import com.kt.claudiattorney.entity.Customer;
import com.kt.claudiattorney.repository.CustomerRepository;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CourtCaseService courtCaseService;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CourtCaseService courtCaseService) {
        this.customerRepository = customerRepository;
        this.courtCaseService = courtCaseService;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public void save(Customer customer) {
        //TODO replace this hack with partial update
        if (customer.getId() != null) {
            Customer one = customerRepository.findOne(customer.getId());
            customer.setCourtCases(one.getCourtCases());
        }
        customerRepository.save(customer);
    }

    public Customer findOne(Long id) {
        return customerRepository.findOne(id);
    }

    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }

    public List<Customer> findAllCustomersNotInCase(Long courtCaseId) {
        List<Customer> customers;
        CourtCase courtCase = courtCaseService.findOne(courtCaseId);
        if (CollectionUtils.isNotEmpty(courtCase.getCustomers())) {
            List<Long> customerIds = courtCase.getCustomers()
                    .stream()
                    .map(Customer::getId)
                    .collect(Collectors.toList());
            customers = customerRepository.findByIdNotIn(customerIds);
        } else {
            customers = customerRepository.findAll();
        }
        return customers;
    }
}
