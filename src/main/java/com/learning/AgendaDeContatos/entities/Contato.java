package com.learning.AgendaDeContatos.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
@Entity
@Table(name = "contatos")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório!")
    private String nome;

    @NotBlank(message = "Email é obrigatório!")
    private String email;

    @NotBlank(message = "Telefone é obrigatório!")
    private String telefone;

    private LocalDate dataCadastro;
    @PrePersist //gera data na hora da criação
    public void prePersist() {this.dataCadastro = LocalDate.now();}
}
