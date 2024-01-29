package com.thuannluit.osahaneat.service;

import com.thuannluit.osahaneat.dto.UserDTO;
import com.thuannluit.osahaneat.entity.Users;
import com.thuannluit.osahaneat.repository.UsersRepository;
import com.thuannluit.osahaneat.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserServiceImp {

    @Autowired
    UsersRepository usersRepository;
    @Override
    public List<UserDTO> getAllUser() {
        List<Users> listUser = usersRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (Users user : listUser) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setUserName(user.getUsername());
            userDTO.setPassword(user.getPassword());
            userDTO.setFullName(user.getFullname());
            userDTO.setCreatedDate(user.getCreate_date());
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }
}
