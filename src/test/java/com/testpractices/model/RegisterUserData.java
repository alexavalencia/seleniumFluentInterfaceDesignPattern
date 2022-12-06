package com.testpractices.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RegisterUserData {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String telephone;
}
