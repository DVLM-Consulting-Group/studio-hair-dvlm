package br.com.dvlm.studiohair.dtos;

import br.com.dvlm.studiohair.domain.Funcionario;

import java.io.Serializable;

public class FuncionarioDTO implements Serializable {

    private static final long serialVersionUID = 985925205593052617L;
    private Integer id;
    private String nome;

    /*@CPF
    private String cpf;*/
    private String telefone;
    private String email;

    public FuncionarioDTO() {
        super();
    }

    public FuncionarioDTO(Funcionario obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        /*this.cpf = obj.getCpf();*/
        this.telefone = obj.getTelefone();
        this.email = obj.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /*public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }*/

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
