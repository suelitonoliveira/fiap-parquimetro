package com.fiap.parquimetro.mapper;

import com.fiap.parquimetro.dto.PagamentoDTO;
import com.fiap.parquimetro.entities.Pagamento;
import com.fiap.parquimetro.entities.Sessao;
import com.fiap.parquimetro.enums.StatusPagamento;

import java.time.LocalDateTime;

public class PagamentoMapper {

    public static Pagamento toEntity(PagamentoDTO pagamentoDTO, Sessao sessao) {

        return Pagamento
                .builder()
                .sessao(sessao)
                .valor(pagamentoDTO.getValor())
                .dataPagamento(LocalDateTime.now())
                .statusPagamento(StatusPagamento.PAGO)
                .build();
    }

    public static PagamentoDTO toDTO(Pagamento pagamento) {
        return PagamentoDTO
                .builder()
                .id(pagamento.getPagamentoId())
                .codUsuario(pagamento.getSessao().getUsuario().getUsuarioId())
                .valor(pagamento.getValor())
                .build();
    }

}
