package br.com.dvlm.studiohair.controllers;

import br.com.dvlm.studiohair.dtos.AgendamentoDTO;
import br.com.dvlm.studiohair.services.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public ResponseEntity<List<AgendamentoDTO>> mostrarTodos(){

        List<AgendamentoDTO> lista = service.mostrarTodos().stream()
                .map(obj -> new AgendamentoDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(lista);
    }

    @PostMapping
    public ResponseEntity<AgendamentoDTO> criar(@Valid @RequestBody AgendamentoDTO obj){
        obj = new AgendamentoDTO(service.criar(obj));

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<AgendamentoDTO> atualizar(@RequestBody AgendamentoDTO obj){
        obj = new AgendamentoDTO(service.atualizar(obj));
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarAgendamento(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
