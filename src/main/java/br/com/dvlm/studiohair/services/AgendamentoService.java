package br.com.dvlm.studiohair.services;

import br.com.dvlm.studiohair.domain.Agendamento;
import br.com.dvlm.studiohair.repositories.AgendamentoRepository;
import br.com.dvlm.studiohair.services.excecoes.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository repository;

    public Agendamento buscaPeloId(Integer id){
        Optional<Agendamento> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Agendamento não encontrado! Id: " +
                id + ", Tipo: " + Agendamento.class.getName()));
    }
}
