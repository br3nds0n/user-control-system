package br.com.api.system.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Audited
@NoArgsConstructor
@AuditOverride(forClass = AbstractModel.class)
public class Usuario extends AbstractModel{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", allocationSize = 1)
    private Long id;

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
