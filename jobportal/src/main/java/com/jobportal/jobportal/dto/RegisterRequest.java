package com.jobportal.jobportal.dto;

import com.jobportal.jobportal.enums.Role;

public class RegisterRequest {
    public String name;
    public String email;
    public String password;
    public Role role;
}
