package com.v2sistemacadastro.v2_cadastro.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record UsuarioRequestDTO(
        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "E-mail Inválido")
        String email,

        @NotBlank(message = "A senha é obrigatória!")
        String senha,

        @Past(message = "A data de nascimento deve ser no passado")
        LocalDate dataNascimento
) {}
