package com.fiap.parquimetro.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "notificacoes")
@Data
public class Notificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sessao_id", nullable = false)
    private Sessao sessao;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String mensagem;

    @Column(name = "data_envio", nullable = false)
    private LocalDateTime dataEnvio;
}
