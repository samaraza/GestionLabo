package com.example.GestionLabo.responseDto;

import com.example.GestionLabo.models.enums.Role;
import lombok.Data;

@Data
public class UserResponseDto {
    private String firstName;
    private String lastName;
    private String email;
    private Role role;


}
