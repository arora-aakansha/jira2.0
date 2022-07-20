package com.random.jira.jira2.controllers;

import com.fasterxml.jackson.databind.JsonSerializable.Base;
import com.random.jira.jira2.entities.User;
import com.random.jira.jira2.exceptions.EmailAlreadyExistsException;
import com.random.jira.jira2.exceptions.NoUserFoundException;
import com.random.jira.jira2.models.BaseResponse;
import com.random.jira.jira2.models.ErrorResponse;
import com.random.jira.jira2.models.UserResponse;
import com.random.jira.jira2.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(value = "/getuser/{id}")
    public ResponseEntity<?> findUserById(@PathVariable Integer id) {
        try {
            BaseResponse<UserResponse> uBaseResponse = userService.findById(id);
            return new ResponseEntity<>(uBaseResponse, HttpStatus.OK);
        } catch (NoUserFoundException e) {
            BaseResponse<ErrorResponse> errorResponse = new BaseResponse<>(false,
                    new ErrorResponse("ID not found"));
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }

    }

}
