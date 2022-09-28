package br.com.api.system.service;

import br.com.api.system.DTO.CepDTO;
import br.com.api.system.api.ViaCepConsumer;
import br.com.api.system.exception.BadRequestException;
import br.com.api.system.model.Usuario;
import br.com.api.system.repository.UsuarioRepository;
import br.com.api.system.utils.CpfUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UsuarioService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private ViaCepConsumer viaCepConsumer;

    public Usuario criar(Usuario usuario) {

        if (!CpfUtil.isCPF(usuario.getCpf())) throw new BadRequestException("Cpf inválido");

        CepDTO response = this.viaCepConsumer.consultarCep(usuario.getCep());
        String senhaHash = this.passwordEncoder.encode(usuario.getSenha());

        usuario.setSenha(senhaHash);

        usuario.setUf(response.getUf());
        usuario.setBairro(response.getBairro());
        usuario.setLocalidade(response.getLocalidade());
        usuario.setLogradouro(response.getLogradouro());

        usuario.setCpf(CpfUtil.formatarCPF(usuario.getCpf()));
        usuario.setCriado(LocalDateTime.now());
        usuario.setModificado(LocalDateTime.now());

        return this.repository.save(usuario);
    }

    public Usuario buscarEmail(String email) {

        Usuario usuario = this.repository.findByEmail(email);

        return usuario;
    }
}
