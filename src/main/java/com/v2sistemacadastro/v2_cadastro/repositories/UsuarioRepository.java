package com.v2sistemacadastro.v2_cadastro.repositories;

import com.v2sistemacadastro.v2_cadastro.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    List<Usuario> findByNomeContaining(String nome);
}
