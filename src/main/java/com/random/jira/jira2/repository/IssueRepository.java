package com.random.jira.jira2.repository;

import com.random.jira.jira2.entities.Issues;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issues, Integer> {

}
