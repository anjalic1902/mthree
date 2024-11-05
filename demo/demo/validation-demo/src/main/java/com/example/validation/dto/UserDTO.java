package com.example.validation.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserDTO {

    @NotNull(message = "{user.name.required}")
    @Size(min = 2, max = 10, message = "{user.name.length}")
    private String name;

    @NotNull(message = "{user.email.required}")
    private String email;

    @NotNull(message = "{user.password.required}")
    @Size(min = 5, message = "{user.password.length}")
    private String password;
}