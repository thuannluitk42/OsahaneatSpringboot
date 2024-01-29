package com.thuannluit.osahaneat.service.imp;

import com.thuannluit.osahaneat.payload.request.SignUpRequest;

public interface LoginServiceImp {
    boolean checkLogin(String username, String password);

    boolean addUser(SignUpRequest signUpRequest);

}
