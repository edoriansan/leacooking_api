package com.leacooking.LeaCooking.api.dto.authentification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequestDTO {
    private String username;
    private String password;
}
