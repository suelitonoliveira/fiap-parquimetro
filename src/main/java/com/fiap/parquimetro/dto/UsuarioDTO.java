package com.fiap.parquimetro.dto;

import com.fiap.parquimetro.entities.Endereco;
import com.fiap.parquimetro.entities.Usuario;
import com.fiap.parquimetro.entities.Veiculo;
import com.fiap.parquimetro.enums.TipoUsuario;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UsuarioDTO {

    private Long id;

    private String nome;
    @NotBlank(message = "Campo Endereco obrigatório")
    private Endereco endereco;
    @NotBlank(message = "Campo cpf obrigatório")
    private String cpf;
    @NotBlank(message = "Campo email obrigatório")
    private String email;
    @NotBlank(message = "Campo telefone obrigatório")
    private String telefone;
    public List<Veiculo> veiculos;
    @NotBlank(message = "Campo tipoUsuario obrigatório")
    public TipoUsuario tipoUsuario;

    public UsuarioDTO() {

    }

    public static Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
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
        dto.setId(entity.getId());
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
