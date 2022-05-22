package com.random.jira.jira2.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
// import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    // @Min(value = 4)
    private String password;

    @OneToOne
    @JoinColumn(name = "id")
    private Department department;

    @OneToMany
    @JoinColumn(name = "issueId")
    private Collection<Issues> issues = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "id")
    private UserProfile userProfile;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Collection<Skills> skills = new ArrayList<>();

}