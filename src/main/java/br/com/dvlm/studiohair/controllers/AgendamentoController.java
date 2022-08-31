package br.com.dvlm.studiohair.controllers;

import br.com.dvlm.studiohair.dtos.AgendamentoDTO;
import br.com.dvlm.studiohair.services.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<AgendamentoDTO> buscaPeloId(@PathVariable Integer id){
        AgendamentoDTO obj = new AgendamentoDTO(service.buscaPeloId(id));
        return ResponseEntity.ok().body(obj);
    }
}
