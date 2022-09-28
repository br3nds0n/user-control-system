package br.com.api.system.controller;

import br.com.api.system.DTO.UsuarioDTO;
import br.com.api.system.model.Usuario;
import br.com.api.system.service.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastrar")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private ModelMapper modelMapper;

    private UsuarioDTO toUsuarioDTO(Usuario usuario) {
        return this.modelMapper.map(usuario, UsuarioDTO.class);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> criar(@RequestBody UsuarioDTO usuarioDTO) {

        Usuario usuario = this.modelMapper.map(usuarioDTO, Usuario.class);
        usuario = this.service.criar(usuario);

        return new ResponseEntity<UsuarioDTO>(toUsuarioDTO(usuario), HttpStatus.CREATED);
    }
}
