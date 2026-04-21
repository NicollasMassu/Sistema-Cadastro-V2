package com.v2sistemacadastro.v2_cadastro.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record UsuarioRequestDTO(
        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "E-mail Inválido")
        String email,

        @NotBlank(message = "A senha é obrigatória!")
        @Size(min = 8)
        String senha,

        @NotNull
        @Past(message = "A data de nascimento deve ser no passado")
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataNascimento
) {}
