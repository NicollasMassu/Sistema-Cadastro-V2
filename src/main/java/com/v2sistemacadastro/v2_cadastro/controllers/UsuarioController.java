package com.v2sistemacadastro.v2_cadastro.controllers;

import com.v2sistemacadastro.v2_cadastro.models.Usuario;
import com.v2sistemacadastro.v2_cadastro.repositories.UsuarioRepository;
import com.v2sistemacadastro.v2_cadastro.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    // Listar todos (Método GET)
    @GetMapping
    public List<Usuario> listar() {
        return service.listarTodos();

    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        Usuario usuario = service.buscarPorId(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }


    // Criar novo usuário (Método POST)
    @PostMapping
    public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario) {
        Usuario novoUsuario = service.salvar(usuario);
        return ResponseEntity.ok(novoUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario usuarioSalvo = service.atualizar(id, usuario);
        return ResponseEntity.ok(usuarioSalvo);
    }
}
