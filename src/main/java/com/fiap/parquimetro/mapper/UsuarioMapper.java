package com.fiap.parquimetro.mapper;

import com.fiap.parquimetro.dto.UsuarioDTO;
import com.fiap.parquimetro.entities.Usuario;

public class UsuarioMapper {
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
