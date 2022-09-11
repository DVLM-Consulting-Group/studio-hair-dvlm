package br.com.dvlm.studiohair.dtos;

import br.com.dvlm.studiohair.domain.Funcionario;
import br.com.dvlm.studiohair.domain.enuns.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FuncionarioDTO implements Serializable {

    private static final long serialVersionUID = 985925205593052617L;
    protected Integer id;

    @NotEmpty(message = "O campo nome é obrigatório!")
    protected String nome;

    @CPF
    @NotEmpty(message = "O campo cpf é obrigatório!")
    protected String cpf;

    @Column(unique = true)
    protected String email;
    protected String senha;

    @NotEmpty(message = "O campo telefone é obrigatório!")
    protected String telefone;

    protected Set<Integer> perfis = new HashSet<>();

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    protected LocalDateTime dataCriacao = LocalDateTime.now();

    public FuncionarioDTO() {
        super();
        addPerfil(Perfil.FUNCIONARIO);
    }

    public FuncionarioDTO(Funcionario obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.telefone = obj.getEmail();
        this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = obj.getDataCriacao();
        addPerfil(Perfil.FUNCIONARIO);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) {
        this.perfis.add(perfil.getCodigo());
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
