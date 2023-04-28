package com.example.userservice.dto;

import com.example.userservice.enums.Role;
import lombok.Data;

@Data
public class UserDto {

    private Integer id;

    private String email;

    private String firstName;

    private String middleName;

    private String lastName;

    private Role role;
}
