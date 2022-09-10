package com.dvlm.studiohair.services;

import com.dvlm.studiohair.domain.Funcionario;
import com.dvlm.studiohair.domain.Usuario;
import com.dvlm.studiohair.domain.dtos.FuncionarioDTO;
import com.dvlm.studiohair.repositories.FuncionarioRepository;
import com.dvlm.studiohair.repositories.UsuarioRepository;
import com.dvlm.studiohair.services.exceptions.ObjectnotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Funcionario findById(Integer id) {
        Optional<Funcionario> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
    }

    public List<Funcionario> findAll() {
        return repository.findAll();
    }

    public Funcionario create (FuncionarioDTO objDTO){
        objDTO.setId(null);
        validaPorCpfEEmail(objDTO);
        Funcionario newObj = new Funcionario(objDTO);
        return repository.save(newObj);
    }
// Validação de CPF e E-mail
    private void validaPorCpfEEmail(FuncionarioDTO objDTO) {
        Optional<Usuario> obj = usuarioRepository.findByCpf(objDTO.getCpf());
        if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
            throw new DataIntegrityViolationException("Cpf já cadastrado no sistema!");
        }
    }
}
