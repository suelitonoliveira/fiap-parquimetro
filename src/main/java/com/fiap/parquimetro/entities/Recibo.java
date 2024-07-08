package com.fiap.parquimetro.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_recibo", schema = "parquimetro")
@Data
public class Recibo extends Auditoria{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sessao_id", nullable = false)
    private Sessao sessao;

    @Column(name = "tempo_estacionado", nullable = false)
    private String tempoEstacionado;

    @Column(name = "tarifa_aplicada", nullable = false)
    private BigDecimal tarifaAplicada;

    @Column(name = "valor_pago", nullable = false)
    private BigDecimal valorPago;

    @Column(name = "data_emissao", nullable = false)
    private LocalDateTime dataEmissao;
}
