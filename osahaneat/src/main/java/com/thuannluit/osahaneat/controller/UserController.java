package com.thuannluit.osahaneat.controller;

import com.thuannluit.osahaneat.payload.ResponseData;
import com.thuannluit.osahaneat.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController  {
    @Autowired
    UserServiceImp userServiceImp;
    @GetMapping("")
    public ResponseEntity<?> getAllUser(){
        ResponseData responseData = new ResponseData();
        responseData.setData(userServiceImp.getAllUser());
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
