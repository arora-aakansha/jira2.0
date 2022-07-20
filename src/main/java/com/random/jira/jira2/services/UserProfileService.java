package com.random.jira.jira2.services;

import java.util.Optional;

import com.random.jira.jira2.entities.UserProfile;
import com.random.jira.jira2.exceptions.NoUserFoundException;
import com.random.jira.jira2.exceptions.UserNameAlreadyExistsException;
import com.random.jira.jira2.models.BaseResponse;
import com.random.jira.jira2.models.UserProfileResponse;

public interface UserProfileService {

    BaseResponse<UserProfileResponse> saveUserProfile(String userName, Long phoneNumber)
            throws UserNameAlreadyExistsException;

    BaseResponse<UserProfileResponse> updateUserProfile(UserProfile userProfile) throws NoUserFoundException;

    BaseResponse<UserProfileResponse> findById(Integer id) throws NoUserFoundException;

    BaseResponse<UserProfileResponse> findByEmail(String userName) throws NoUserFoundException;

}
