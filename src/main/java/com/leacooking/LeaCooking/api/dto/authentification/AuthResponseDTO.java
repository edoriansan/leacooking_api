package com.leacooking.LeaCooking.api.dto.authentification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDTO {
    private String token;
    private String username;
    private String message;
}
