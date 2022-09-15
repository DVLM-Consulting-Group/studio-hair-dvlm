package br.com.dvlm.studiohair.services;

import br.com.dvlm.studiohair.domain.Agendamento;
import br.com.dvlm.studiohair.domain.Cliente;
import br.com.dvlm.studiohair.domain.Funcionario;
import br.com.dvlm.studiohair.domain.enuns.Servico;
import br.com.dvlm.studiohair.domain.enuns.Status;
import br.com.dvlm.studiohair.repositories.AgendamentoRepository;
import br.com.dvlm.studiohair.repositories.ClienteRepository;
import br.com.dvlm.studiohair.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public void instanciaDB(){
        Funcionario f1 = new Funcionario(null, "Luan Braz", "059.483.300-01", "(12) 99214-5667",
                "luan_email@dvlm.com.br");
        Cliente c1 = new Cliente(null, "Maria Silva", "851.147.451-07", "(61) 88268-1234",
                "maria_email@email.com.br");

        Agendamento ag1 = new Agendamento(null, Servico.CORTE, "Testando sistema", Status.ABERTO, f1, c1,
                new BigDecimal(50.00));

        f1.getLista().add(ag1);
        c1.getLista().add(ag1);

        funcionarioRepository.saveAll(Arrays.asList(f1));
        clienteRepository.saveAll(Arrays.asList(c1));
        agendamentoRepository.saveAll(Arrays.asList(ag1));
    }
}
