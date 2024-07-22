package com.fiap.parquimetro.entities;

import com.fiap.parquimetro.enums.StatusPagamento;
import com.fiap.parquimetro.enums.TipoPagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="tb_pagamento", schema = "parquimetro")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento extends Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    private Long pagamentoId;

    @ManyToOne
    @JoinColumn(name = "sessao_id", nullable = false)
    private Sessao sessao;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(name = "data_pagamento", nullable = false)
    private LocalDateTime dataPagamento;

    @Column(name = "status_pagamento", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusPagamento statusPagamento =  StatusPagamento.PENDENTE;

    @Column(name = "tipo_pagamento", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;
}
