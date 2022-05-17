package com.random.jira.jira2.repository;

import com.random.jira.jira2.entities.Department;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
