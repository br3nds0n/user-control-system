package br.com.api.system.controller;

import br.com.api.system.exception.BadRequestException;
import br.com.api.system.model.Usuario;
import br.com.api.system.security.JwtRequest;
import br.com.api.system.security.JwtResponse;
import br.com.api.system.security.JwtTokenUtil;
import br.com.api.system.security.JwtUserDetailsService;
import br.com.api.system.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioService usuarioService;

    public Usuario usuarioUtil(String email) {
        return this.usuarioService.buscarEmail(email);
    }

    private void autenticacao(String email, String senha) throws BadRequestException {
        Usuario usuario = this.usuarioUtil(email);

        if (usuario == null) throw new BadRequestException("e-mail inválido");
        if (!passwordEncoder.matches(senha, usuario.getSenha())) throw new BadRequestException("senha inválida");
    }

    @PostMapping
    public ResponseEntity<JwtResponse> criarAutenticacaoToken(@RequestBody JwtRequest response) {
        Usuario usuario = this.usuarioUtil(response.getEmail());

        this.autenticacao(response.getEmail(), response.getSenha());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(response.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);

        JwtResponse jwtResponse = new JwtResponse(token, usuario.getId(), usuario.getUsuario());

        return new ResponseEntity<>(jwtResponse, HttpStatus.CREATED);
    }
}
