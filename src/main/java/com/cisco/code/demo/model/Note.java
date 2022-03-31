package com.cisco.code.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Table(name="note_table")
@Entity(name="Note")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "note_id")
    private Integer noteId;

    @Column(name = "case_id")
    private Integer caseId;

    @Column(name = "details")
    private String details;

}
