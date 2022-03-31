package com.cisco.code.demo.service;

import com.cisco.code.demo.model.Case;
import com.cisco.code.demo.model.Note;

import java.util.List;

public interface CaseService {
    List<Case> getCasesWithStatus(Case.Status status);
    List<Case> getOpenCasesByUserId(Integer userId);
    List<Case> getOpenCasesByUserIdAndStatus(Integer userId, Case.Status status);
    Case getCaseById(Integer caseId);
    Case createCase(Case toCreate);
    Note addNote(Note note);
}
