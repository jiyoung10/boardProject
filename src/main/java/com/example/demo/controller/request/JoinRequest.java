package com.example.demo.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinRequest {
    private String userId;
    private String password;
    private String userName;
    private String phoneNumber;
}
