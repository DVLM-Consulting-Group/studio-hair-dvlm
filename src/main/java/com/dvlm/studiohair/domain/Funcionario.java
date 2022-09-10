package com.dvlm.studiohair.domain;

import com.dvlm.studiohair.domain.dtos.FuncionarioDTO;
import com.dvlm.studiohair.domain.enuns.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Funcionario extends Usuario{
    private static final long serialVersionUID = 1L;
    @JsonIgnore // Protegendo aplicação contra Serialização
    @OneToMany(mappedBy = "funcionario")
    private List<Agendamento> agendamentos = new ArrayList<>();

    public Funcionario() {
        super();
        addPerfil(Perfil.FUNCIONARIO);
    }

    public Funcionario(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfil(Perfil.FUNCIONARIO);
    }

    public Funcionario(FuncionarioDTO obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = obj.getDataCriacao();
    }
    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
