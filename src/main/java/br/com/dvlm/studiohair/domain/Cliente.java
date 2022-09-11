package br.com.dvlm.studiohair.domain;

import br.com.dvlm.studiohair.domain.enuns.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente extends Pessoa implements Serializable {

    private static final long serialVersionUID = -8810856798536130648L;
    @JsonIgnore
    @OneToMany(mappedBy = "cliente") // foi mapeado pelo cliente
    private List<Agendamento> agendamentos = new ArrayList<>();


    public Cliente(){
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public Cliente(Integer id, String nome, String cpf, String email, String senha, String telefone) {
        super(id, nome, cpf, email, senha, telefone);
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }
}
