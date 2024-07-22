package com.fiap.parquimetro.mapper;

import com.fiap.parquimetro.dto.ParquimetroDTO;
import com.fiap.parquimetro.dto.UsuarioDTO;
import com.fiap.parquimetro.entities.Endereco;
import com.fiap.parquimetro.entities.Parquimetro;
import com.fiap.parquimetro.entities.Usuario;
import com.fiap.parquimetro.entities.Veiculo;

import java.util.List;
import java.util.Objects;

public class ParquimetroMapper {

    public static Parquimetro toEntity(ParquimetroDTO parquimetroDTO, UsuarioDTO usuarioDTO, Endereco endereco, List<Veiculo> listaVeiculo) {
        Usuario usuario = UsuarioMapper.toEntity(usuarioDTO, endereco, listaVeiculo);
        return Parquimetro
                .builder()
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
                .codUsuario(parquimetroSalvo.getUsuario().getUsuarioId())
                .build();
    }

    public static Parquimetro updateEntity(Parquimetro parquimetroExistente, ParquimetroDTO parquimetroDTO, UsuarioDTO usuarioDTO, Endereco endereco, List<Veiculo> listaVeiculo) {
        Usuario usuario = UsuarioMapper.toEntity(usuarioDTO,endereco, listaVeiculo);
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
