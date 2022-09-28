package br.com.api.system.exception;

import lombok.Getter;

import java.util.List;

@Getter
public class ErrorMessage {

    private int status;
    private String erro;
    private String descricao;

    public ErrorMessage(int status, String erro, String descricao) {
        this.status = status;
        this.erro = erro;
        this.descricao = descricao;
    }
}
