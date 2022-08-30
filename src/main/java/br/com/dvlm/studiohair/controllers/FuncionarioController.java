package br.com.dvlm.studiohair.controllers;

import br.com.dvlm.studiohair.domain.Funcionario;
import br.com.dvlm.studiohair.dtos.FuncionarioDTO;
import br.com.dvlm.studiohair.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> buscarTodos(){

        List<FuncionarioDTO> listaDTO =funcionarioService.buscarTodos().stream()
                .map(func -> new FuncionarioDTO(func)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listaDTO);
    }

    @PostMapping
    public ResponseEntity<Funcionario> criarNovoFuncionario(@Valid @RequestBody FuncionarioDTO funcionarioDTO){
        Funcionario newFunc = funcionarioService.criarNovoFuncionario(funcionarioDTO);

        // PASSAR URI DE ACESSO AO NOVO OBJ
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newFunc.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FuncionarioDTO> update(@PathVariable Integer id, @Valid @RequestBody FuncionarioDTO objDTO){
        FuncionarioDTO newObj = new FuncionarioDTO(funcionarioService.update(id, objDTO));

        return ResponseEntity.ok().body(newObj);
    }
}
