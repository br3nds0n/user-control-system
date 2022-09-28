package br.com.api.system.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

    private String email;
    private String usuario;
    private String senha;

    private String cpf;
    private String cep;
    private String uf;
    private String bairro;
    private String localidade;
    private String logradouro;
    private String complemento;
}
