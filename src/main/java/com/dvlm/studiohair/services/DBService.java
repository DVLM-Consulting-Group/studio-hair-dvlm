package com.dvlm.studiohair.services;

import com.dvlm.studiohair.domain.Agendamento;
import com.dvlm.studiohair.domain.Cliente;
import com.dvlm.studiohair.domain.Funcionario;
import com.dvlm.studiohair.domain.Servico;
import com.dvlm.studiohair.domain.enuns.Perfil;
import com.dvlm.studiohair.domain.enuns.Prioridade;
import com.dvlm.studiohair.domain.enuns.Status;
import com.dvlm.studiohair.repositories.AgendamentoRepository;
import com.dvlm.studiohair.repositories.ClienteRepository;
import com.dvlm.studiohair.repositories.FuncionarioRepository;
import com.dvlm.studiohair.repositories.ServicoRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    // Injeção de Dependências

    private final FuncionarioRepository funcionarioRepository;
    private final ClienteRepository clienteRepository;
    private final ServicoRepository servicoRepository;
    private final AgendamentoRepository agendamentoRepository;

    public DBService(FuncionarioRepository funcionarioRepository, ClienteRepository clienteRepository, ServicoRepository servicoRepository, AgendamentoRepository agendamentoRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.clienteRepository = clienteRepository;
        this.servicoRepository = servicoRepository;
        this.agendamentoRepository = agendamentoRepository;
    }

    public void instanciaDB(){

        Funcionario f1 = new Funcionario(null,"Matheus Gerente","629.988.730-30",
                "matheusgerente@gmail.com","123456");
        f1.addPerfil(Perfil.ADMIN);

        Cliente c1 = new Cliente(null,"Linus Trovalds","548.169.780-70",
                "linustrovalds@gmail.com","123");
        c1.addPerfil(Perfil.CLIENTE);

        Servico s1 = new Servico(null,"Corte Masculino",
                "Cortar o cabelo masculino",20.00);

        Funcionario f2 = new Funcionario(null,"Matheus Funcionario","456.123.023-50",
                "matheusfuncionario@gmail.com","123456");
        f1.addPerfil(Perfil.ADMIN);

        Agendamento a1 = new Agendamento(null, Status.ABERTO, Prioridade.MEDIA,f1,s1,c1);

        funcionarioRepository.saveAll(Arrays.asList(f1));
        clienteRepository.saveAll(Arrays.asList(c1));
        servicoRepository.saveAll(Arrays.asList(s1));
        agendamentoRepository.saveAll(Arrays.asList(a1));
        funcionarioRepository.saveAll(Arrays.asList(f2));
    }
}
