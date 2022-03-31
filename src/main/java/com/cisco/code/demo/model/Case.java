package com.cisco.code.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Table(name="case_table")
@Entity(name="Case")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer caseId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "severity")
    private Integer severity;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "case_user_id", referencedColumnName = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "case_id")
    private List<Note> notes;

    public enum Status {
        OPEN,
        CLOSED
    }

}
