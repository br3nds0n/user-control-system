package br.com.api.system.security;

import br.com.api.system.exception.NotFoundException;
import br.com.api.system.model.Usuario;
import br.com.api.system.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioService service;

    @Override
    public UserDetails loadUserByUsername(String email) throws NotFoundException {
        Usuario usuario = this.service.buscarEmail(email);

        if (usuario.getEmail().equals(email)) {
            return new User(email, usuario.getSenha(),
                    new ArrayList<>());
        } else {
            throw new NotFoundException("email não encontrado");
        }
    }
}
