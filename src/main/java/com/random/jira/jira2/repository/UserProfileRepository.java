package com.random.jira.jira2.repository;

import com.random.jira.jira2.entities.UserProfile;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {

}
