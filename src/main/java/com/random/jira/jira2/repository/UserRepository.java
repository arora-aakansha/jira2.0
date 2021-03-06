package com.random.jira.jira2.repository;

import java.util.Optional;

import com.random.jira.jira2.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    public Optional<User> findByEmail(String email);

}
