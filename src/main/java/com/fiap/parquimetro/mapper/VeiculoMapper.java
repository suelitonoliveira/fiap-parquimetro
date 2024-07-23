package com.fiap.parquimetro.mapper;

import com.fiap.parquimetro.dto.VeiculoDto;
import com.fiap.parquimetro.entities.Usuario;
import com.fiap.parquimetro.entities.Veiculo;

import java.util.Objects;

public class VeiculoMapper {

    public static VeiculoDto toDTO(Veiculo veiculo) {
        return VeiculoDto
                .builder()
                .id(veiculo.getId())
                .marca(veiculo.getMarca())
                .modelo(veiculo.getModelo())
                .placa(veiculo.getPlaca())
                .build();
    }


    public static Veiculo toUpdate(Veiculo veiculoExistente, Veiculo veiculo) {
        return Veiculo
                .builder()
                .id(veiculoExistente.getId())
                .placa(Objects.nonNull(veiculo.getPlaca()) ? veiculo.getPlaca() : veiculoExistente.getPlaca())
                .modelo(Objects.nonNull(veiculo.getModelo()) ? veiculo.getModelo() : veiculoExistente.getModelo())
                .marca(Objects.nonNull(veiculo.getMarca()) ? veiculo.getMarca() : veiculoExistente.getMarca())
                .usuario(Objects.nonNull(veiculo.getUsuario()) ? veiculo.getUsuario() : veiculoExistente.getUsuario())
                .build();
    }

    public static Veiculo toEntity(VeiculoDto veiculoDto, Usuario usuario) {
        return Veiculo
                .builder()
                .id(veiculoDto.getId())
                .usuario(usuario)
                .marca(veiculoDto.getMarca())
                .placa(veiculoDto.getPlaca())
                .modelo(veiculoDto.getModelo())
                .build();
    }
}
