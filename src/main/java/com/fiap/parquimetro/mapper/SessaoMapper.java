package com.fiap.parquimetro.mapper;

import com.fiap.parquimetro.dto.SessaoDTO;
import com.fiap.parquimetro.entities.Parquimetro;
import com.fiap.parquimetro.entities.Sessao;
import com.fiap.parquimetro.entities.Usuario;
import com.fiap.parquimetro.enums.StatusPagamento;

import java.time.LocalDateTime;

public class SessaoMapper {
    public static SessaoDTO toDTO(Sessao sessao) {
        return SessaoDTO
                .builder()
                .id(sessao.getId())
                .inicioSessao(sessao.getInicioSessao())
                .fimSessao(sessao.getFimSessao())
                .parquimetroId(sessao.getParquimetro().getId())
                .usuarioId(sessao.getUsuario().getUsuarioId())
                .statusPagamento(sessao.getStatusPagamento())
                .build();
    }

    public static Sessao toEntity(SessaoDTO sessaoDTO, Parquimetro parquimetro, Usuario usuario) {
        return Sessao
                .builder()
                .inicioSessao(LocalDateTime.now())
                .fimSessao(sessaoDTO.getFimSessao())
                .statusPagamento(StatusPagamento.PENDENTE)
                .parquimetro(parquimetro)
                .usuario(usuario)
                .build();
    }
}
