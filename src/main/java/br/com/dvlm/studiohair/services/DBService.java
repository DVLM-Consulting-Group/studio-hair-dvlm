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
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public void instanciaDB() {

        LocalDateTime data1 = LocalDateTime.of(2022, 9, 20, 6, 30);

        LocalDateTime data2 = LocalDateTime.of(2022, 9, 22, 11, 30);


        Funcionario f1 = new Funcionario(null, "Marcia Santos", "059.483.300-01", "(12) 99214-5667",
                "marcia@email.com.br");

        Funcionario f2 = new Funcionario(null, "Carla Silva", "424.606.060-79", "(12) 98756-5667",
                "carla@email.com.br");

        Cliente c1 = new Cliente(null, "Maria Silva", "851.147.451-07", "(61) 88268-1234",
                "maria_email@email.com.br");

        Cliente c2 = new Cliente(null, "Lucia Silva", "321.736.580-18", "(61) 94712-1123",
                "lucia@email.com.br");

        Agendamento ag1 = new Agendamento(null, Servico.CORTE, "Testando sistema", Status.ABERTO, f1, c1,
                new BigDecimal(50.00), data1 );

        Agendamento ag2 = new Agendamento(null, Servico.MANICURE, "Testando sistema", Status.ABERTO, f1, c1,
                new BigDecimal(50.00), data1 );

        f1.getLista().add(ag1);
        c1.getLista().add(ag1);

        f2.getLista().add(ag2);
        c2.getLista().add(ag2);





        funcionarioRepository.saveAll(Arrays.asList(f1, f2));
        clienteRepository.saveAll(Arrays.asList(c1, c2));
        agendamentoRepository.saveAll(Arrays.asList(ag1, ag2));
    }
}
