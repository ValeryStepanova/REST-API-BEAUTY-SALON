package com.example.springbeautysalon.dto;
import com.example.springbeautysalon.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int id;

    private String login;

    private String password;

    private Role role;

}
