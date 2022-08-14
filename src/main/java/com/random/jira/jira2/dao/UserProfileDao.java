package com.random.jira.jira2.dao;

import java.util.Optional;

import com.random.jira.jira2.entities.UserProfile;

public interface UserProfileDao {

    UserProfile saveOrUpdate(UserProfile userProfile);

    Optional<UserProfile> findById(Integer id);

    Optional<UserProfile> findByUsername(String userName);

}
