package com.kt.claudiattorney.dto;

import com.kt.claudiattorney.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerForm {

    private List<Customer> customers;
}
