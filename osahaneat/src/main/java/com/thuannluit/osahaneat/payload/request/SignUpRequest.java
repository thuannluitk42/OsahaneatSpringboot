package com.thuannluit.osahaneat.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {
    private String fullName;
    private String email;
    private String password;
    private int roleId;
}
