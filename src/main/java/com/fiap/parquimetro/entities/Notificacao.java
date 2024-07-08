package com.fiap.parquimetro.entities;

import com.fiap.parquimetro.enums.TipoNotificacao;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_notificacao", schema = "parquimetro")
@Data
public class Notificacao extends Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "SECAO_ID", nullable = false)
    private Sessao sessao;

    @Column(name = "TIPO_NOTIFICACAO", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoNotificacao tipoNotificacao = TipoNotificacao.EMAIL;

    @Column(nullable = false)
    private String mensagem;

    @Column(name = "data_envio", nullable = false)
    private LocalDateTime dataEnvio;
}
