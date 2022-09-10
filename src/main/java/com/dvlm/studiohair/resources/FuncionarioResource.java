package com.dvlm.studiohair.resources;

import com.dvlm.studiohair.domain.Funcionario;
import com.dvlm.studiohair.domain.dtos.FuncionarioDTO;
import com.dvlm.studiohair.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioResource {

    @Autowired
    private FuncionarioService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<FuncionarioDTO> findById(@PathVariable Integer id){
        Funcionario obj = this.service.findById(id);
        return ResponseEntity.ok().body(new FuncionarioDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> findAll(){
        List<Funcionario> list = service.findAll();
        List<FuncionarioDTO> listDTO = list.stream().map(obj -> new FuncionarioDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTO> create(@RequestBody FuncionarioDTO objDTO){
        Funcionario newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").
                buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
