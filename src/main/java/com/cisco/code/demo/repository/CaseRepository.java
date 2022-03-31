package com.cisco.code.demo.repository;

import com.cisco.code.demo.model.Case;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CaseRepository extends CrudRepository<Case, Integer> {
    List<Case> findByStatus(Case.Status status);

    Case findByCaseId(Integer caseId);
}
