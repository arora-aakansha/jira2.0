package com.random.jira.jira2.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "issues")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Issues {
    @Id
    @GeneratedValue
    private int issueId;

    private String description;

    @OneToOne
    @JoinColumn(name = "assignedTo")
    private User assignedTo;

    @OneToOne
    @JoinColumn(name = "assignedBy")
    private User assignedBy;

    @ManyToOne(cascade = CascadeType.ALL)
    private User creator;

    private String status;

    private String priority;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    private String type;

}
