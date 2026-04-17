package com.v2sistemacadastro.v2_cadastro.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.v2sistemacadastro.v2_cadastro.dtos.UsuarioRequestDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "O nome é obrigatório!")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres!")
    private String nome;

    @NotBlank(message = "O email é obrigatório!")
    @Email(message = "Por favor, insira um e-mail válido!")
    private String email;

    @NotBlank(message = "A senha é obrigatória!")
    private String senha;

    @NotNull(message = "A data de nascimento é obrigatória!")
    @Past(message = "A data de nascimento deve ser uma data no passado!")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    public Usuario(UsuarioRequestDTO dto) {
        this.nome = dto.nome();
        this.email = dto.email();
        this.senha = dto.senha(); // Lembre-se de adicionar o campo senha na sua Entity se ainda não tiver
        this.dataNascimento = dto.dataNascimento();

    }
}
