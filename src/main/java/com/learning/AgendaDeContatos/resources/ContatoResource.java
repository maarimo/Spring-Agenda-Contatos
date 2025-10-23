package com.learning.AgendaDeContatos.resources;

import com.learning.AgendaDeContatos.entities.Contato;
import com.learning.AgendaDeContatos.services.ContatoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatoResource {

    private final ContatoService service;
    public ContatoResource(ContatoService service) {this.service = service;}

    @GetMapping
    public ResponseEntity<List<Contato>> listar(){
        List<Contato> list = service.listar();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> buscar(@PathVariable Long id){
        Contato contato = service.buscarPorId(id);
        return ResponseEntity.ok(contato);
    }

    @PostMapping
    public ResponseEntity<Contato> criar(@Valid @RequestBody Contato contato){
        Contato criado = service.criar(contato);
        URI uri =URI.create("/contatos/" + criado.getId());
        return ResponseEntity.created(uri).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contato> atualizar(@PathVariable Long id, @Valid @RequestBody Contato contato){
        Contato atualizado = service.atualizar(id, contato);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
