package br.com.dvlm.studiohair.dtos;

import br.com.dvlm.studiohair.domain.Agendamento;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;

public class AgendamentoDTO implements Serializable {
    private static final long serialVersionUID = 6445065446023076514L;

    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataAgendamento;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataExServico;

    private Integer servico;

    @NotEmpty(message = "O campo é obrigatério!")
    private String observacoes;
    private Integer status;

    private Integer funcionario;

    private Integer cliente;

//    @NotNull

    public AgendamentoDTO() {
        super();
    }

    public AgendamentoDTO(Agendamento obj) {
        this.id = obj.getId();
        this.dataAgendamento = obj.getDataAgendamento();
        this.dataExServico = obj.getDataExServico();
        this.observacoes = obj.getObservacoes();
        this.status = obj.getStatus().getCod();
        this.funcionario = obj.getFuncionario().getId();
        this.cliente = obj.getCliente().getId();
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

    public Integer getServico() {
        return servico;
    }

    public void setServico(Integer servico) {
        this.servico = servico;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Integer funcionario) {
        this.funcionario = funcionario;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }


}
