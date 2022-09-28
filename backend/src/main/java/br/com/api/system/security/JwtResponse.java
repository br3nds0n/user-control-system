package br.com.api.system.security;

import lombok.Getter;

@Getter
public class JwtResponse {

    private final String token;

    public JwtResponse(String jwttoken) {
        this.token = jwttoken;
    }
}
