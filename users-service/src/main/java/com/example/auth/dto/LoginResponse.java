package com.example.auth.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true) // ✅ Active le chaînage

public class LoginResponse {
    private String token;

    private long expiresIn;


}
