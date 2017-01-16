package com.kt.claudiattorney.service;

import com.kt.claudiattorney.entity.Case;
import com.kt.claudiattorney.repository.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseService {

    private final CaseRepository caseRepository;

    @Autowired
    public CaseService(CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    public List<Case> findAll() {
        return caseRepository.findAll();
    }

    public Case save(Case aCase) {
        return caseRepository.save(aCase);
    }
}
