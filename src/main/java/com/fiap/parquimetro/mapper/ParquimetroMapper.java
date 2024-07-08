package com.fiap.parquimetro.mapper;

import com.fiap.parquimetro.dto.ParquimetroDTO;
import com.fiap.parquimetro.entities.Parquimetro;
import com.fiap.parquimetro.entities.Usuario;

import java.util.Objects;

public class ParquimetroMapper {

    public static Parquimetro toEntity(ParquimetroDTO parquimetroDTO, Usuario usuario) {
        return Parquimetro
                .builder()
                .id(Objects.nonNull(parquimetroDTO.getId()) ? parquimetroDTO.getId() : null)
                .modelo(parquimetroDTO.getModelo())
                .numeroSerie(parquimetroDTO.getNumeroSerie())
                .usuario(usuario)
                .build();
    }

    public static ParquimetroDTO toDTO(Parquimetro parquimetroSalvo) {
        return ParquimetroDTO
                .builder()
                .id(parquimetroSalvo.getId())
                .modelo(parquimetroSalvo.getModelo())
                .numeroSerie(parquimetroSalvo.getNumeroSerie())
                .codUsuario(parquimetroSalvo.getUsuario().getId())
                .build();
    }
}
