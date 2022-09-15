package br.com.dvlm.studiohair.domain;

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
    private List<Agendamento> lista = new ArrayList<>();

    public Cliente() {
        super();
    }

    public Cliente(Integer id, String nome, String cpf, String telefone, String email) {
        super(id, nome, cpf, telefone, email);
    }

    public List<Agendamento> getLista() {
        return lista;
    }

    public void setLista(List<Agendamento> lista) {
        this.lista = lista;
    }
}
