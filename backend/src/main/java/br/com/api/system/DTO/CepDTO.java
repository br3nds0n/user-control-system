package br.com.api.system.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CepDTO {

    private String cep;
    private String uf;
    private String bairro;
    private String localidade;
    private String logradouro;
    private String complemento;
}
