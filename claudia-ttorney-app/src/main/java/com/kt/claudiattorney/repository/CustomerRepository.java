package com.kt.claudiattorney.repository;

import com.kt.claudiattorney.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
