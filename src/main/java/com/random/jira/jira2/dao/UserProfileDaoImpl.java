package com.random.jira.jira2.dao;

import java.util.Optional;

import com.random.jira.jira2.entities.UserProfile;
import com.random.jira.jira2.repository.UserProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class UserProfileDaoImpl implements UserProfileDao {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public UserProfile saveOrUpdate(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    @Override
    public Optional<UserProfile> findById(Integer id) {
        return userProfileRepository.findById(id);
    }

    @Override
    public Optional<UserProfile> findByUsername(String userName) {
        return userProfileRepository.findByUsername(userName);
    }

}
