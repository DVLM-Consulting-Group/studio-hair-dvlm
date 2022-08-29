package br.com.dvlm.studiohair.services;

import br.com.dvlm.studiohair.domain.Funcionario;
import br.com.dvlm.studiohair.repositories.FuncionarioRepository;
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
}
