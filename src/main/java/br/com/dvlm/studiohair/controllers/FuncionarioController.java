package br.com.dvlm.studiohair.controllers;

import br.com.dvlm.studiohair.dtos.FuncionarioDTO;
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
    public ResponseEntity<FuncionarioDTO> buscarPeloId(@PathVariable Integer id){
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO(funcionarioService.buscarPeloId(id));
        return ResponseEntity.ok().body(funcionarioDTO);
    }
}
