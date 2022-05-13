package com.random.jira.jira2.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

    private String name;
    private String email;
    private String password;

    @OneToOne
    @JoinColumn(name = "id")
    private Department department;

    @OneToMany
    @JoinColumn(name = "issueId")
    private Collection<Issues> issues;

    @OneToOne
    @JoinColumn(name = "id")
    private UserProfile userProfile;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Collection<Skills> skills;

}