package br.com.api.system.security;

import lombok.Getter;

@Getter
public class JwtResponse {

    private final Long id;
    private final String token;
    private final String usuario;


    public JwtResponse(String jwttoken, Long id, String usuario) {
        this.id = id;
        this.token = jwttoken;
        this.usuario = usuario;
    }
}
