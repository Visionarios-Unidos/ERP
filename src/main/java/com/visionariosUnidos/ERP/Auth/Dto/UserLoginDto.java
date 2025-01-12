package com.visionariosUnidos.ERP.Auth.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserLoginDto {
    @Email
    @NotEmpty
    @Column(unique = true, nullable = false)
    private String email;

    @NotEmpty
    private String password;
}
