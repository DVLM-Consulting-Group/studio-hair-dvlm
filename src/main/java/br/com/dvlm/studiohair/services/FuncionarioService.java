package br.com.dvlm.studiohair.services;

import br.com.dvlm.studiohair.domain.Funcionario;
import br.com.dvlm.studiohair.domain.Pessoa;
import br.com.dvlm.studiohair.dtos.FuncionarioDTO;
import br.com.dvlm.studiohair.repositories.FuncionarioRepository;
import br.com.dvlm.studiohair.repositories.PessoaRepository;
import br.com.dvlm.studiohair.services.excecoes.DataIntegratyViolationException;
import br.com.dvlm.studiohair.services.excecoes.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public  Funcionario buscarPeloId(Integer id){
        Optional<Funcionario> obj = funcionarioRepository.findById(id); //pode encontrar ou não!
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Funcionario.class.getName()));
    }

    public List<Funcionario> buscarTodos() {
        return funcionarioRepository.findAll();
    }

    public Funcionario criarNovoFuncionario(FuncionarioDTO funcionarioDTO){

        if (buscarPorCPF(funcionarioDTO) != null){
            throw new DataIntegratyViolationException(
                    "CPF já cadastrado na base de dados!");      // exception de INTEGRIDADE DE DADOS
        }

        Funcionario newFunc = new Funcionario(null, funcionarioDTO.getNome(), funcionarioDTO.getCpf(),
                funcionarioDTO.getTelefone(), funcionarioDTO.getEmail(), funcionarioDTO.getTelefone());

        return funcionarioRepository.save(newFunc);
    }


    public Funcionario update(Integer id, @Valid FuncionarioDTO objDTO) {
        Funcionario objVelho = buscarPeloId(id);

        if (buscarPorCPF(objDTO) != null && buscarPorCPF(objDTO).getId() != id){
            throw new DataIntegratyViolationException(
                    "CPF já cadastrado na base de dados!");
        }

        objVelho.setNome(objDTO.getNome());
        objVelho.setCpf(objDTO.getCpf());
        objVelho.setTelefone(objDTO.getTelefone());
        objVelho.setEmail(objDTO.getEmail());

        return funcionarioRepository.save(objVelho);
    }

    public void delete(Integer id) {
        Funcionario obj = buscarPeloId(id);

        if (obj.getAgendamentos().size() > 0){
            throw new DataIntegratyViolationException("Funcionário possui agendamento aberto, portanto não pode ser deletado!");
        }

        funcionarioRepository.deleteById(id);
    }


    private Pessoa buscarPorCPF(FuncionarioDTO objDTO){
        Pessoa obj = pessoaRepository.buscarPorCPF(objDTO.getCpf());
        if ( obj != null){
            return obj;
        }
        return null;
    }

}
