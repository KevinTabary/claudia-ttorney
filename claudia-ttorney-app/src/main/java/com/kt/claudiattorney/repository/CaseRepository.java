package com.kt.claudiattorney.repository;

import com.kt.claudiattorney.entity.Case;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseRepository extends JpaRepository<Case, Long> {
}
