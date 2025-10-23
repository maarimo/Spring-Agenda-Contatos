package com.learning.AgendaDeContatos.services;

import com.learning.AgendaDeContatos.entities.Contato;
import com.learning.AgendaDeContatos.exceptions.ResourceNotFoundException;
import com.learning.AgendaDeContatos.repositories.ContatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    private final ContatoRepository repo;

    public ContatoService(ContatoRepository repo) {this.repo = repo;}

    public List<Contato> listar(){
        return repo.findAll();
    }

    public Contato buscarPorId(Long id){
        return repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Contato não encontrado: " + id));
    }

    public Contato criar(Contato contato){
        return repo.save(contato);
    }

    public Contato atualizar(Long id, Contato contato){
        Contato existente = buscarPorId(id);

        existente.setNome(contato.getNome());
        existente.setEmail(contato.getEmail());
        existente.setTelefone(contato.getTelefone());

        return repo.save(existente);
    }

    public void deletar(Long id){
        if(!repo.existsById(id)){
            throw new ResourceNotFoundException("Contato não encontrado: " + id);
        }

        repo.deleteById(id);
    }
}