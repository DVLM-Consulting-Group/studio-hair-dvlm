package br.com.dvlm.studiohair.dtos;

import br.com.dvlm.studiohair.domain.Funcionario;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class FuncionarioDTO implements Serializable {

    private static final long serialVersionUID = 985925205593052617L;
    private Integer id;

    @NotEmpty(message = "O campo nome é obrigatório!")
    private String nome;

    @CPF
    @NotEmpty(message = "O campo cpf é obrigatório!")
    private String cpf;

    @NotEmpty(message = "O campo telefone é obrigatório!")
    private String telefone;
    private String email;

    public FuncionarioDTO() {
        super();
    }

    public FuncionarioDTO(Funcionario obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

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
