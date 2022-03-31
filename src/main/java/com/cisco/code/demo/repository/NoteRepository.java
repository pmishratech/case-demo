package com.cisco.code.demo.repository;

import com.cisco.code.demo.model.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Integer> {
}
