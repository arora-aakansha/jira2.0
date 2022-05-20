package com.random.jira.jira2.services;

import java.util.Optional;

import com.random.jira.jira2.config.ApplicationConfig;
import com.random.jira.jira2.dao.UserDao;
import com.random.jira.jira2.entities.User;
import com.random.jira.jira2.exceptions.EmailAlreadyExistsException;
import com.random.jira.jira2.exceptions.NoUserFoundException;
import com.random.jira.jira2.models.BaseResponse;
import com.random.jira.jira2.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public BaseResponse<User> saveUser(String name, String password, String email) throws EmailAlreadyExistsException {
        Optional<User> userOptional = userDao.findByEmail(email);
        if (userOptional.isPresent()) {
            throw new EmailAlreadyExistsException("Email Already exists");
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        User savedUser = userDao.saveOrUpdateUser(user);
        return new BaseResponse<>(true, savedUser);
    }

    @Override
    public BaseResponse<User> searchUser(Integer id) throws NoUserFoundException {
        // TODO Auto-generated method stub
        return null;
    }

}