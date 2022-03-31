package com.cisco.code.demo.service;

import com.cisco.code.demo.model.Case;
import com.cisco.code.demo.model.Note;
import com.cisco.code.demo.model.User;
import com.cisco.code.demo.repository.CaseRepository;
import com.cisco.code.demo.repository.NoteRepository;
import com.cisco.code.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaseServiceImpl implements CaseService {

    @Autowired
    CaseRepository caseRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    NoteRepository noteRepository;

    @Override
    public List<Case> getCasesWithStatus(Case.Status status) {
        return caseRepository.findByStatus(status);
    }

    @Override
    public List<Case> getOpenCasesByUserId(Integer userId) {
        List<Case> openCases = getCasesWithStatus(Case.Status.OPEN);
        User user = userRepository.findByUserId(userId);
        return openCases.stream().filter(ele -> ele.getUser().getUserId().equals(user.getUserId())).collect(Collectors.toList());
    }

    @Override
    public List<Case> getOpenCasesByUserIdAndStatus(Integer userId, Case.Status status) {
        List<Case> openCases = getCasesWithStatus(Case.Status.OPEN);
        User user = userRepository.findByUserId(userId);
        return openCases.stream().filter(ele -> ele.getUser().getUserId().equals(user.getUserId())).collect(Collectors.toList());
    }

    @Override
    public Case getCaseById(Integer caseId) {
        return caseRepository.findByCaseId(caseId);
    }

    @Override
    public Case createCase(Case toCreate) {
        return caseRepository.save(toCreate);
    }

    @Override
    public Note addNote(Note note) {
        return noteRepository.save(note);
    }
}
