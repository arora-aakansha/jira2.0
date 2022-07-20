package com.random.jira.jira2.services;

import java.util.Optional;

import com.random.jira.jira2.dao.UserDao;
import com.random.jira.jira2.entities.User;
import com.random.jira.jira2.exceptions.EmailAlreadyExistsException;
import com.random.jira.jira2.exceptions.NoUserFoundException;
import com.random.jira.jira2.models.BaseResponse;
import com.random.jira.jira2.models.UserResponse;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    // @Autowired
    // private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public BaseResponse<UserResponse> saveUser(String name, String password, String email)
            throws EmailAlreadyExistsException {
        Optional<User> userOptional = userDao.findByEmail(email);
        if (userOptional.isPresent()) {
            throw new EmailAlreadyExistsException("Email Already exists");
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        // user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setPassword(password);
        User savedUser = userDao.saveOrUpdateUser(user);
        UserResponse userResponse = new UserResponse(savedUser);
        return new BaseResponse<>(true, userResponse);
    }

    @Override
    public BaseResponse<UserResponse> findById(Integer id) throws NoUserFoundException {
        Optional<User> userFound = userDao.findById(id);
        if (!userFound.isPresent()) {
            throw new NoUserFoundException("No user Found");
        }
        UserResponse userResponse = new UserResponse(userFound.get());
        return new BaseResponse<>(true, userResponse);
    }

    @Override
    public BaseResponse<UserResponse> findByEmail(String email) throws NoUserFoundException {
        Optional<User> userFound = userDao.findByEmail(email);
        if (!userFound.isPresent()) {
            throw new NoUserFoundException("No user found for email given email");
        }
        UserResponse userResponse = new UserResponse(userFound.get());
        return new BaseResponse<>(true, userResponse);
    }

    @Override
    public BaseResponse<UserResponse> updateUser(User user) throws NoUserFoundException {
        Optional<User> userFound = userDao.findById(user.getId());
        if (!userFound.isPresent()) {
            throw new NoUserFoundException("No user found for email given email");
        }
        return null;
    }

}
