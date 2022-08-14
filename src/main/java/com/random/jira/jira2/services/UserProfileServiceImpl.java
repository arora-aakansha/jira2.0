package com.random.jira.jira2.services;

import java.util.Optional;

import com.random.jira.jira2.dao.UserProfileDao;
import com.random.jira.jira2.entities.UserProfile;
import com.random.jira.jira2.exceptions.NoUserFoundException;
import com.random.jira.jira2.exceptions.UserNameAlreadyExistsException;
import com.random.jira.jira2.models.BaseResponse;
import com.random.jira.jira2.models.UserProfileResponse;

import org.springframework.beans.factory.annotation.Autowired;

public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileDao userProfileDao;

    @Override
    public BaseResponse<UserProfileResponse> saveUserProfile(String userName, Long phoneNumber)
            throws UserNameAlreadyExistsException {
        Optional<UserProfile> findUserProfile = userProfileDao.findByUsername(userName);
        if (findUserProfile.isPresent()) {
            throw new UserNameAlreadyExistsException(userName + " UseName already exists in database");
        }
        UserProfile userProfile = new UserProfile();
        userProfile.setPhoneNumber(phoneNumber);
        userProfile.setUsername(userName);
        UserProfile saveProfile = userProfileDao.saveOrUpdate(userProfile);
        UserProfileResponse userProfileResponse = new UserProfileResponse(saveProfile);
        return new BaseResponse<>(true, userProfileResponse);
    }

    @Override
    public BaseResponse<UserProfileResponse> updateUserProfile(UserProfile userProfile) throws NoUserFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BaseResponse<UserProfileResponse> findById(Integer id) throws NoUserFoundException {
        Optional<UserProfile> findUserProfile = userProfileDao.findById(id);
        if (!findUserProfile.isPresent()) {
            throw new NoUserFoundException("UseProfile with given id not found");
        }
        UserProfileResponse userProfileResponse = new UserProfileResponse(findUserProfile.get());
        return new BaseResponse<>(true, userProfileResponse);

    }

    @Override
    public BaseResponse<UserProfileResponse> findByEmail(String userName) throws NoUserFoundException {
        Optional<UserProfile> findUserProfile = userProfileDao.findByUsername(userName);
        if (!findUserProfile.isPresent()) {
            throw new NoUserFoundException("UseProfile with given id not found");
        }
        UserProfileResponse userProfileResponse = new UserProfileResponse(findUserProfile.get());
        return new BaseResponse<>(true, userProfileResponse);
    }

}
