package com.v2sistemacadastro.v2_cadastro.services;

import com.v2sistemacadastro.v2_cadastro.dtos.UsuarioRequestDTO;
import com.v2sistemacadastro.v2_cadastro.dtos.UsuarioResponseDTO;
import com.v2sistemacadastro.v2_cadastro.exceptions.BusinessException;
import com.v2sistemacadastro.v2_cadastro.exceptions.ResourceNotFoundException;
import com.v2sistemacadastro.v2_cadastro.models.Usuario;
import com.v2sistemacadastro.v2_cadastro.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Transactional
    public UsuarioResponseDTO cadastrar(UsuarioRequestDTO dto) {
        if (repository.existsByEmail(dto.email())) {
            throw new BusinessException("E-mail já cadastrado!");
        }

        Usuario usuario = new Usuario(dto);

        usuario = repository.save(usuario);

        return new UsuarioResponseDTO(usuario);
    }

    @Transactional(readOnly = true)
    public List<UsuarioResponseDTO> listarTodos() {

        List<Usuario> usuarios = repository.findAll();

        return usuarios.stream()
                .map(UsuarioResponseDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public UsuarioResponseDTO buscarPorId(Long id) {

        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + id));

        return new UsuarioResponseDTO(usuario);
    }

    @Transactional
    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
        Usuario usuarioExistente = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + id));

        if (!dto.email().equals(usuarioExistente.getEmail()) && repository.existsByEmail(dto.email())) {
            throw new BusinessException("O e-mail " + dto.email() + " já está em uso por outro usuário.");
            }

            usuarioExistente.setNome(dto.nome());
            usuarioExistente.setEmail(dto.email());
            usuarioExistente.setSenha(dto.senha());
            usuarioExistente.setDataNascimento(dto.dataNascimento());

            usuarioExistente = repository.save(usuarioExistente);
            return new UsuarioResponseDTO(usuarioExistente);
        }

        @Transactional
        public void excluir (Long id){
            if (!repository.existsById(id)) {
                throw new ResourceNotFoundException("Não foi possível excluir: Usuário não encontrado com ID: " + id);
            }
            repository.deleteById(id);
        }

    }