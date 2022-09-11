package br.com.dvlm.studiohair.services;

import br.com.dvlm.studiohair.domain.Cliente;
import br.com.dvlm.studiohair.domain.Pessoa;
import br.com.dvlm.studiohair.dtos.ClienteDTO;
import br.com.dvlm.studiohair.repositories.ClienteRepository;
import br.com.dvlm.studiohair.repositories.PessoaRepository;
import br.com.dvlm.studiohair.services.excecoes.DataIntegratyViolationException;
import br.com.dvlm.studiohair.services.excecoes.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public  Cliente buscarPeloId(Integer id){
        Optional<Cliente> obj = clienteRepository.findById(id); //pode encontrar ou não!
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente criarNovoCliente(ClienteDTO clienteDTO){

        if (buscarPorCPF(clienteDTO) != null){
            throw new DataIntegratyViolationException(
                    "CPF já cadastrado na base de dados!");      // exception de INTEGRIDADE DE DADOS
        }

        Cliente newFunc = new Cliente(null, clienteDTO.getNome(), clienteDTO.getCpf(),
                clienteDTO.getTelefone(), clienteDTO.getEmail());

        return clienteRepository.save(newFunc);
    }


    public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
        Cliente objVelho = buscarPeloId(id);

        if (buscarPorCPF(objDTO) != null && buscarPorCPF(objDTO).getId() != id){
            throw new DataIntegratyViolationException(
                    "CPF já cadastrado na base de dados!");
        }

        objVelho.setNome(objDTO.getNome());
        objVelho.setCpf(objDTO.getCpf());
        objVelho.setTelefone(objDTO.getTelefone());
        objVelho.setEmail(objDTO.getEmail());

        return clienteRepository.save(objVelho);
    }

    public void delete(Integer id) {
        Cliente obj = buscarPeloId(id);

        if (obj.getLista().size() > 0){
            throw new DataIntegratyViolationException("Cliente possui agendamento aberto, portanto não pode ser deletado!");
        }

        clienteRepository.deleteById(id);
    }


    private Pessoa buscarPorCPF(ClienteDTO objDTO){
        Pessoa obj = pessoaRepository.buscarPorCPF(objDTO.getCpf());
        if ( obj != null){
            return obj;
        }
        return null;
    }

}
