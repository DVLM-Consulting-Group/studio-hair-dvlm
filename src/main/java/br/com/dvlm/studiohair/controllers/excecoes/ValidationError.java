package br.com.dvlm.studiohair.controllers.excecoes;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{
    private static final long serialVersionUID = -9182856541535931580L;

    private List<FieldMessage> erros = new ArrayList<>();

    public ValidationError() {
        super();
    }

    public ValidationError(Long momentoDoErro, Integer status, String erro) {
        super(momentoDoErro, status, erro);
        this.erros = erros;
    }

    public List<FieldMessage> getErros() {
        return erros;
    }

    public void addErro(String nomeDoErro, String mensagem) {
        this.erros.add(new FieldMessage(nomeDoErro, mensagem));
    }

}
