package com.fiap.parquimetro.entities;

import com.fiap.parquimetro.dto.UsuarioDTO;
import com.fiap.parquimetro.enums.TipoUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "tb_usuario", schema = "parquimetro")
public class Usuario extends Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    private Long usuarioId;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "ENDERECO_ID", nullable = false)
    private Endereco endereco;

    @Column(name = "CPF", nullable = false, unique = true)
    private String cpf;

    @Column(name = "EMAIL", nullable = false)
    @Email
    private String email;

    @Column(name = "TELEFONE", nullable = false)
    private String telefone;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    public List<Veiculo> veiculos;

    @Column(name = "TIPO_USUARIO", nullable = false)
    @Enumerated(EnumType.STRING)
    public TipoUsuario tipoUsuario;



    public static Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setUsuarioId(dto.getUsuarioId());
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setEndereco(dto.getEndereco());
        usuario.setCpf(dto.getCpf());
        usuario.setTelefone(dto.getTelefone());
        usuario.setVeiculos(dto.getVeiculos());
        usuario.setTipoUsuario(dto.getTipoUsuario());
        return usuario;
    }

    public static UsuarioDTO toDTO(Usuario entity) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setUsuarioId(entity.getUsuarioId());
        dto.setNome(entity.getNome());
        dto.setEmail(entity.getEmail());
        dto.setEndereco(entity.getEndereco());
        dto.setCpf(entity.getCpf());
        dto.setTelefone(entity.getTelefone());
        dto.setVeiculos(entity.getVeiculos());
        dto.setTipoUsuario(entity.getTipoUsuario());
        return dto;
    }
}
