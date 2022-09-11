package br.com.dvlm.studiohair.controllers;

import br.com.dvlm.studiohair.domain.Cliente;
import br.com.dvlm.studiohair.dtos.ClienteDTO;
import br.com.dvlm.studiohair.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")   // faz com q api esteja disponivel para requisições de mult. fontes
@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> buscarPeloId(@PathVariable Integer id){
        ClienteDTO clienteDTO = new ClienteDTO(clienteService.buscarPeloId(id));
        return ResponseEntity.ok().body(clienteDTO);
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> buscarTodos(){

        List<ClienteDTO> listaDTO =clienteService.buscarTodos().stream()
                .map(client -> new ClienteDTO(client)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listaDTO);
    }

    @PostMapping
    public ResponseEntity<Cliente> criarNovoCliente(@Valid @RequestBody ClienteDTO clienteDTO){
        Cliente newClient = clienteService.criarNovoCliente(clienteDTO);

        // PASSAR URI DE ACESSO AO NOVO OBJ
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newClient.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Integer id, @Valid @RequestBody ClienteDTO objDTO){
        ClienteDTO newObj = new ClienteDTO(clienteService.update(id, objDTO));

        return ResponseEntity.ok().body(newObj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
