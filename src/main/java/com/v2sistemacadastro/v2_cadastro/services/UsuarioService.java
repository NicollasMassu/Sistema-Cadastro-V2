package com.v2sistemacadastro.v2_cadastro.services;

import com.v2sistemacadastro.v2_cadastro.models.Usuario;
import com.v2sistemacadastro.v2_cadastro.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    // Método para listar todos
    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Usuario salvar(Usuario usuario) {
        usuario.setEmail(usuario.getEmail().toLowerCase());

        return repository.save(usuario);
    }

    public Usuario atualizar(Long id, Usuario usuarioAtualizado) {
        Usuario usuarioExistente = repository.findById(id).get();

        usuarioExistente.setNome(usuarioAtualizado.getNome());
        usuarioExistente.setEmail(usuarioAtualizado.getEmail());
        usuarioExistente.setDataNascimento(usuarioAtualizado.getDataNascimento());

        return repository.save(usuarioExistente);

    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public Usuario buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }


}
