package com.example.library_db.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String phone;

    @Enumerated(EnumType.STRING)
    private MembershipType membershipType;

    private LocalDate membershipStartDate;

    private boolean active = true;

    @OneToMany(mappedBy = "member")
    private List<BookIssue> issues;
}
