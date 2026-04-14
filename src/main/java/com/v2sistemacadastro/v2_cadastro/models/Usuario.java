package com.v2sistemacadastro.v2_cadastro.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String email;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;



}
