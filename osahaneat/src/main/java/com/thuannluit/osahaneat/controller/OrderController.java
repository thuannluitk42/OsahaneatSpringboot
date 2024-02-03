package com.thuannluit.osahaneat.controller;

import com.thuannluit.osahaneat.payload.ResponseData;
import com.thuannluit.osahaneat.payload.request.OrderRequest;
import com.thuannluit.osahaneat.service.imp.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderServiceImp orderServiceImp;
    @PostMapping ()
    public ResponseEntity<?> getAllUser(@RequestBody OrderRequest orderRequest){
        return new ResponseEntity<>(orderServiceImp.insertOrder(orderRequest), HttpStatus.OK);
    }
}
