package br.com.dvlm.studiohair.domain;

import br.com.dvlm.studiohair.domain.enuns.Perfil;
import br.com.dvlm.studiohair.dtos.FuncionarioDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Funcionario extends Pessoa implements Serializable {

    private static final long serialVersionUID = -8810856798536130648L;
    @JsonIgnore
    @OneToMany(mappedBy = "funcionario") // foi mapeado pelo cliente
    private List<Agendamento> agendamentos = new ArrayList<>();


    public Funcionario(){
        super();
        addPerfil(Perfil.FUNCIONARIO);
    }

    public Funcionario(Integer id, String nome, String cpf, String email, String senha, String telefone) {
        super(id, nome, cpf, email, senha, telefone);
        addPerfil(Perfil.FUNCIONARIO);
    }

    public Funcionario(FuncionarioDTO obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.telefone= obj.getTelefone();
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

