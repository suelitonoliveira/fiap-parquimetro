package com.fiap.parquimetro.mapper;

import com.fiap.parquimetro.dto.EnderecoDTO;
import com.fiap.parquimetro.entities.Endereco;

public class EnderecoMapper {
    public static Endereco toEntity(EnderecoDTO enderecoDTO) {
        return Endereco
                .builder()
                .logradouro(enderecoDTO.getLogradouro())
                .numero(enderecoDTO.getNumero())
                .complemento(enderecoDTO.getComplemento())
                .cidade(enderecoDTO.getCidade())
                .estado(enderecoDTO.getEstado())
                .cep(enderecoDTO.getCep())
                .build();
    }

    public static EnderecoDTO toDto(Endereco endereco) {
        return EnderecoDTO
                .builder()
                .id(endereco.getId())
                .logradouro(endereco.getLogradouro())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .cidade(endereco.getCidade())
                .estado(endereco.getEstado())
                .cep(endereco.getCep())
                .build();
    }
}
