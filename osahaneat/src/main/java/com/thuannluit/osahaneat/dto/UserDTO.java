package com.thuannluit.osahaneat.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDTO {
    private int id;
    private String userName;
    private String password;
    private String fullName;
    private Date createdDate;
}
