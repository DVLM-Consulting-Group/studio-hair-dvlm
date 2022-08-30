package br.com.dvlm.studiohair.services;

import br.com.dvlm.studiohair.domain.Funcionario;
import br.com.dvlm.studiohair.dtos.FuncionarioDTO;
import br.com.dvlm.studiohair.repositories.FuncionarioRepository;
import br.com.dvlm.studiohair.services.excecoes.DataIntegratyViolationException;
import br.com.dvlm.studiohair.services.excecoes.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario buscarPeloId(Integer id){
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
                funcionarioDTO.getTelefone(), funcionarioDTO.getEmail());

        return funcionarioRepository.save(newFunc);
    }

    private Funcionario buscarPorCPF(FuncionarioDTO funcionarioDTO){
        Funcionario funcionario = funcionarioRepository.buscarPorCPF(funcionarioDTO.getCpf());
        if ( funcionario != null){
            return funcionario;
        }
        return null;
    }
}
