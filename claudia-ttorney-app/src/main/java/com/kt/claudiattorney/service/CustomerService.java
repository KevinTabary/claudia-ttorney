package com.kt.claudiattorney.service;

import com.kt.claudiattorney.entity.Customer;
import com.kt.claudiattorney.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer findOne(Long id) {
        return customerRepository.findOne(id);
    }
}
