package com.v2sistemacadastro.v2_cadastro.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.v2sistemacadastro.v2_cadastro.models.Usuario;

import java.time.LocalDate;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String email,
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataNascimento
) {
    public UsuarioResponseDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getDataNascimento());
    }
}
