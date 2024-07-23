package com.fiap.parquimetro.mapper;

import com.fiap.parquimetro.dto.ParquimetroDTO;
import com.fiap.parquimetro.dto.UsuarioDTO;
import com.fiap.parquimetro.dto.VeiculoDto;
import com.fiap.parquimetro.entities.Parquimetro;
import com.fiap.parquimetro.entities.Usuario;
import com.fiap.parquimetro.entities.Veiculo;

import java.util.Objects;

public class VeiculoMapper {

    public static Veiculo toEntity(VeiculoDto veiculoDto, UsuarioDTO usuarioDTO) {
        Usuario usuario = UsuarioMapper.toEntity(usuarioDTO);
        return Veiculo
                .builder()
                .id(veiculoDto.getId())
                .usuario(usuario)
                .marca(veiculoDto.getMarca())
                .placa(veiculoDto.getNumeroPlaca())
                .modelo(veiculoDto.getModelo())
                .build();
    }

    public static VeiculoDto toDTO(Veiculo veiculo) {
        return VeiculoDto
                .builder()
                .id(veiculo.getId())
                .marca(veiculo.getMarca())
                .modelo(veiculo.getModelo())
                .numeroPlaca(veiculo.getPlaca())
                .build();
    }

    public static Parquimetro updateEntity(Parquimetro parquimetroExistente, ParquimetroDTO parquimetroDTO, UsuarioDTO usuarioDTO) {
        Usuario usuario = UsuarioMapper.toEntity(usuarioDTO);
        return Parquimetro
                .builder()
                .id(parquimetroExistente.getId())
                .modelo(Objects.nonNull(parquimetroDTO.getModelo()) ? parquimetroDTO.getModelo() : parquimetroExistente.getModelo())
                .numeroSerie(parquimetroDTO.getNumeroSerie())
                .usuario(usuario)
                .dataDeInclusao(parquimetroExistente.getDataDeInclusao())
                .build();

    }
}
