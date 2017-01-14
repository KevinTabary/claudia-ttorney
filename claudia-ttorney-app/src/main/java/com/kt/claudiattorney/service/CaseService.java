package com.kt.claudiattorney.service;

import com.kt.claudiattorney.entity.Case;
import com.kt.claudiattorney.entity.Prestation;
import org.springframework.stereotype.Service;

@Service
public class CaseService {

    public void createGlobalBill(Case aCase) {
        Double amount = aCase.getPrestations()
                .stream()
                .mapToDouble(Prestation::getPriceIncludingVat)
                .sum();
    }
}
