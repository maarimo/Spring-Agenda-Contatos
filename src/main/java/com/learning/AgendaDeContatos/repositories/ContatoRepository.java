package com.learning.AgendaDeContatos.repositories;

import com.learning.AgendaDeContatos.entities.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
