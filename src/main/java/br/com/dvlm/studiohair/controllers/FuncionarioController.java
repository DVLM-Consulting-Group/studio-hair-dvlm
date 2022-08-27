package br.com.dvlm.studiohair.controllers;

import br.com.dvlm.studiohair.domain.Funcionario;
import br.com.dvlm.studiohair.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Funcionario> buscarPeloId(@PathVariable Integer id){
        Funcionario funcionario = funcionarioService.buscarPeloId(id);
        return ResponseEntity.ok().body(funcionario);
    }
}
