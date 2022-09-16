package br.com.dvlm.studiohair.services;

import br.com.dvlm.studiohair.domain.Agendamento;
import br.com.dvlm.studiohair.domain.Cliente;
import br.com.dvlm.studiohair.domain.Funcionario;
import br.com.dvlm.studiohair.domain.enuns.Servico;
import br.com.dvlm.studiohair.domain.enuns.Status;
import br.com.dvlm.studiohair.dtos.AgendamentoDTO;
import br.com.dvlm.studiohair.repositories.AgendamentoRepository;
import br.com.dvlm.studiohair.services.excecoes.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private AgendamentoRepository repository;

    public Agendamento buscaPeloId(Integer id){
        Optional<Agendamento> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Agendamento não encontrado! Id: " +
                id + ", Tipo: " + Agendamento.class.getName()));
    }

    public List<Agendamento> mostrarTodos(){
        return repository.findAll();
    }

    public Agendamento criar(AgendamentoDTO obj) {
        return fromDTO(obj);
    }

    public Agendamento atualizar(AgendamentoDTO obj) {
        buscaPeloId(obj.getId());
        return fromDTO(obj);
    }

    private Agendamento fromDTO(AgendamentoDTO obj){
        Agendamento newObj = new Agendamento();
        newObj.setId(obj.getId());
        newObj.setObservacoes(obj.getObservacoes());
        newObj.setServico(Servico.toEnum(obj.getServico().getCod()));
        newObj.setStatus(Status.toEnum(obj.getStatus().getCod()));
        newObj.setValor(obj.getValor());

        Funcionario func = funcionarioService.buscarPeloId(obj.getFuncionario());

        Cliente client = clienteService.buscarPeloId(obj.getCliente());

        newObj.setFuncionario(func);
        newObj.setCliente(client);

        return repository.save(newObj);
    }


    public void delete(Integer id) {
        Agendamento obj = buscaPeloId(id);

        repository.deleteById(id);
    }
}
