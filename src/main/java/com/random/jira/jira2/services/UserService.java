package com.random.jira.jira2.services;

import com.random.jira.jira2.entities.User;
import com.random.jira.jira2.exceptions.EmailAlreadyExistsException;
import com.random.jira.jira2.exceptions.NoUserFoundException;
import com.random.jira.jira2.models.BaseResponse;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    BaseResponse<User> saveUser(String name, String password, String email) throws EmailAlreadyExistsException;

    BaseResponse<User> searchUser(Integer id) throws NoUserFoundException;

}
