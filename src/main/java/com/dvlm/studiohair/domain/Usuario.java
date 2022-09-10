package com.dvlm.studiohair.domain;

import com.dvlm.studiohair.domain.enuns.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public abstract class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
     protected Integer id;
     protected String nome;
     @Column(unique = true) // Confirmando que só terá 1 CPF único, ou seja , não pode haver 2 CPFs iguais.
     protected String cpf;
    @Column(unique = true) // Confirmando que só terá 1 e-mail único, ou seja , não pode haver 2 e-mails iguais.
     protected String email;
     protected String senha;
     @ElementCollection(fetch = FetchType.EAGER) // Confirmando que a minha lista de perfis virá junto com o usuário
     @CollectionTable(name = "PERFIS") // haverá uma tabela no banco apenas com os PERFIS
     protected Set<Integer> perfis = new HashSet<>();
     @JsonFormat(pattern = "dd/MM/yyyy")
     protected LocalDate dataCriacao = LocalDate.now();

     public Usuario() {
        super();
        addPerfil(Perfil.FUNCIONARIO);
    }

    public Usuario(Integer id, String nome, String cpf, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
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

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) {
        this.perfis.add(perfil.getCodigo());
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id.equals(usuario.id) && cpf.equals(usuario.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf);
    }
}
