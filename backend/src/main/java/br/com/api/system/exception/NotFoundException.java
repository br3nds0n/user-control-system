package br.com.api.system.exception;

public class NotFoundException extends AbstractException {

    public NotFoundException(String descricao) {
        super("NotFound", descricao);
    }
}
