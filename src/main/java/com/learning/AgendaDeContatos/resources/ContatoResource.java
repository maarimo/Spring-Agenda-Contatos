package com.learning.AgendaDeContatos.resources;

import com.learning.AgendaDeContatos.entities.Contato;
import com.learning.AgendaDeContatos.services.ContatoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
