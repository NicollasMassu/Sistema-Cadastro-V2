package com.v2sistemacadastro.v2_cadastro.dtos;

import com.v2sistemacadastro.v2_cadastro.models.Usuario;

import java.time.LocalDate;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String email,
        String senha,
        LocalDate dataNascimento
) {
    public UsuarioResponseDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getDataNascimento());
    }
}
