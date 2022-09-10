package com.dvlm.studiohair.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Servico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeServico;
    private String descricaoServico;
    private Double precoServico;

    public Servico(){
        super();
    }

    public Servico(Integer id, String nomeServico, String descricaoServico, Double precoServico) {
        this.id = id;
        this.nomeServico = nomeServico;
        this.descricaoServico = descricaoServico;
        this.precoServico = precoServico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public Double getPrecoServico() {
        return precoServico;
    }

    public void setPrecoServico(Double precoServico) {
        this.precoServico = precoServico;
    }
}
