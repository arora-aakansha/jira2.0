package com.random.jira.jira2.dao;

import java.util.Optional;

import com.random.jira.jira2.entities.User;

public interface UserDao {
    User saveOrUpdateUser(User user);

    Optional<User> findById(Integer id);

    Optional<User> findByEmail(String email);

}
