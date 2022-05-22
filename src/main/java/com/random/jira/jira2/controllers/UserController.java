package com.random.jira.jira2.controllers;

import com.fasterxml.jackson.databind.JsonSerializable.Base;
import com.random.jira.jira2.entities.User;
import com.random.jira.jira2.exceptions.EmailAlreadyExistsException;
import com.random.jira.jira2.models.BaseResponse;
import com.random.jira.jira2.models.ErrorResponse;
import com.random.jira.jira2.models.UserResponse;
import com.random.jira.jira2.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws EmailAlreadyExistsException {
        System.out.println("I am User COntroller");
        try {
            BaseResponse<UserResponse> userResponse = userService.saveUser(user.getName(), user.getPassword(),
                    user.getEmail());
            ResponseEntity response = new ResponseEntity<>(userResponse, HttpStatus.CREATED);
            System.out.println(response);
            return response;
        } catch (EmailAlreadyExistsException e) {
            BaseResponse<ErrorResponse> errorResponse = new BaseResponse<>(false,
                    new ErrorResponse("Email already exists"));
            return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
        }
    }

}
