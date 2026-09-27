package com.ga.Todo.Model.Request;

import lombok.Getter;

@Getter
public class LoginRequest {
    private String email;
    private String password;
}