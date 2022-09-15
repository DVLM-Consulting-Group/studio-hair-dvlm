package br.com.dvlm.studiohair.controllers.excecoes;

import java.io.Serializable;

public class FieldMessage implements Serializable {
    private static final long serialVersionUID = -2017916763592536593L;

    private String nomeDoCampo;
    private String mensagem;

    public FieldMessage() {
        super();
    }

    public FieldMessage(String nomeDoCampo, String mensagem) {
        this.nomeDoCampo = nomeDoCampo;
        this.mensagem = mensagem;
    }

    public String getNomeDoCampo() {
        return nomeDoCampo;
    }

    public void setNomeDoCampo(String nomeDoCampo) {
        this.nomeDoCampo = nomeDoCampo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
