package com.kt.claudiattorney.service;

import com.kt.claudiattorney.entity.CourtCase;
import com.kt.claudiattorney.repository.CourtCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourtCaseService {

    private final CourtCaseRepository courtCaseRepository;

    @Autowired
    public CourtCaseService(CourtCaseRepository courtCaseRepository) {
        this.courtCaseRepository = courtCaseRepository;
    }

    public List<CourtCase> findAll() {
        return courtCaseRepository.findAll();
    }

    public CourtCase findOne(Long courtCaseId) {
        return courtCaseRepository.findOne(courtCaseId);
    }
}
