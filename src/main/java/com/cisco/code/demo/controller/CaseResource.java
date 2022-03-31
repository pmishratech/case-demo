package com.cisco.code.demo.controller;

import com.cisco.code.demo.model.Case;
import com.cisco.code.demo.model.Note;
import com.cisco.code.demo.service.CaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class CaseResource {

    @Autowired
    CaseService caseService;

    @GetMapping("/cases/status/{status}")
    ResponseEntity<Object> getCasesWithStatus(@PathVariable Case.Status status) {
        log.info("Calling getCasesWithStatus with status {}", status);
        return new ResponseEntity<>(caseService.getCasesWithStatus(status), HttpStatus.OK);
    }

    @GetMapping("/cases/user/{userId}")
    ResponseEntity<Object> getOpenCases(@PathVariable Integer userId) {
        log.info("Calling getOpenCases with userId {}", userId);
        return new ResponseEntity<>(caseService.getOpenCasesByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/cases/user/{userId}/status/{status}")
    ResponseEntity<Object> getOpenCases(@PathVariable Integer userId, @PathVariable Case.Status status) {
        log.info("Calling getOpenCases with userId  {} and status {}", userId, status);
        return new ResponseEntity<>(caseService.getOpenCasesByUserIdAndStatus(userId, status), HttpStatus.OK);
    }

    @GetMapping("/case/{caseId}")
    ResponseEntity<Object> getCase(@PathVariable Integer caseId) {
        log.info("Calling getCase with caseId  {}", caseId);
        return new ResponseEntity<>(caseService.getCaseById(caseId), HttpStatus.OK);
    }

    @PostMapping(value = "/case/create", consumes = "application/json")
    ResponseEntity<Object> createCase(@RequestBody Case toCreate) {
        log.info("Calling createCase with case  {}", toCreate);
        return new ResponseEntity<>(caseService.createCase(toCreate), HttpStatus.CREATED);
    }

    @PostMapping(value = "/case/{caseId}/addNote", consumes = "application/json")
    ResponseEntity<Object> addNote(@PathVariable Integer caseId, @RequestBody String detail) {
        Note note = new Note();
        note.setCaseId(caseId);
        note.setDetails(detail);
        log.info("Calling addNote with note  {}", note);
        return new ResponseEntity<>(caseService.addNote(note), HttpStatus.CREATED);
    }
}
