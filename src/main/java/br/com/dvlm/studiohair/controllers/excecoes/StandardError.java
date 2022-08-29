package br.com.dvlm.studiohair.controllers.excecoes;

import java.io.Serializable;

public class StandardError implements Serializable {

    private static final long serialVersionUID = 4456046933280951304L;
    private Long momentoDoErro;

    private Integer status;

    private String erro;

    public StandardError() {
        super();
    }

    public StandardError(Long momentoDoErro, Integer status, String erro) {
        this.momentoDoErro = momentoDoErro;
        this.status = status;
        this.erro = erro;
    }

    public Long getMomentoDoErro() {
        return momentoDoErro;
    }

    public void setMomentoDoErro(Long momentoDoErro) {
        this.momentoDoErro = momentoDoErro;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }
}
