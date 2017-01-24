package com.kt.claudiattorney.repository;

import com.kt.claudiattorney.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByIdNotIn(Collection<Long> id);
}
