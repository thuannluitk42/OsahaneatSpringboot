package com.thuannluit.osahaneat.service;

import com.thuannluit.osahaneat.entity.Roles;
import com.thuannluit.osahaneat.entity.Users;
import com.thuannluit.osahaneat.payload.request.SignUpRequest;
import com.thuannluit.osahaneat.repository.UsersRepository;
import com.thuannluit.osahaneat.service.imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements LoginServiceImp {
    @Autowired
    //@Qualifier("tên bean") - trường hợp có nhiều class cùng tên trên container
    UsersRepository usersRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean checkLogin(String username, String password){
        Users user = usersRepository.findByUsername(username);
        return passwordEncoder.matches(password, user.getPassword());
    }

    @Override
    public boolean addUser(SignUpRequest signUpRequest) {
        Users users = new Users();
        Roles roles = new Roles();
        roles.setId(signUpRequest.getRoleId());
        users.setFullname(signUpRequest.getFullName());
        users.setUsername(signUpRequest.getEmail());
        users.setPassword(signUpRequest.getPassword());
        users.setRoles(roles);
        try {
            usersRepository.save(users);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
