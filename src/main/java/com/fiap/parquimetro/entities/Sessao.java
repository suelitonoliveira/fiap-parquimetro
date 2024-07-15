package com.fiap.parquimetro.entities;

import com.fiap.parquimetro.enums.StatusPagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="tb_sessao", schema = "parquimetro")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Sessao extends Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "condutor_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "parquimetro_id", nullable = false)
    private Parquimetro parquimetro;

    @Column(name = "status_pagamento", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusPagamento statusPagamento;

    @Column(name = "inicio_sessao", nullable = false)
    private LocalDateTime inicioSessao;

    @Column(name = "fim_sessao")
    private LocalDateTime fimSessao;



}
