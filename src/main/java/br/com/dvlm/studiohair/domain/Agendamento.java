package br.com.dvlm.studiohair.domain;

import br.com.dvlm.studiohair.domain.enuns.Servico;
import br.com.dvlm.studiohair.domain.enuns.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Agendamento {

    private Integer id;
    private LocalDateTime dataAgendamento;
    private LocalDateTime dataExServico;
    private Integer servico;
    private String observacoes;
    private Integer status;
    private Funcionario funcionario;
    private Cliente cliente;
    private BigDecimal valor;

    public Agendamento() {
        super();
        this.setDataAgendamento(LocalDateTime.now());   // passa a data atual no momento do agendamento
        this.setStatus(Status.ABERTO);
        this.setServico(Servico.OUTROS);
    }

    public Agendamento(Integer id, Servico servico, String observacoes, Status status, Funcionario funcionario,
                       Cliente cliente, BigDecimal valor) {
        super();
        this.id = id;
        this.valor = valor;
        this.setDataAgendamento(LocalDateTime.now());
        this.servico = (servico == null) ? 0 : servico.getCod();
        this.observacoes = observacoes;
        this.status = (status == null) ? 0 : status.getCod();
        this.funcionario = funcionario;
        this.cliente = cliente;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDateTime dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public LocalDateTime getDataExServico() {
        return dataExServico;
    }

    public void setDataExServico(LocalDateTime dataExServico) {
        this.dataExServico = dataExServico;
    }

    public Servico getServico() {
        return Servico.toEnum(this.servico);
    }

    public void setServico(Servico servico) {
        this.servico = servico.getCod();
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Status getStatus() {
        return Status.toEnum(this.status);
    }

    public void setStatus(Status status) {
        this.status = status.getCod();
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agendamento that = (Agendamento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
