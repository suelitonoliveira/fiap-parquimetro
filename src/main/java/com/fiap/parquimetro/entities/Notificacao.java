package com.fiap.parquimetro.entities;

import com.fiap.parquimetro.enums.TipoNotificacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_notificacao", schema = "parquimetro")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
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
    private TipoNotificacao tipoNotificacao;

    @Column(nullable = false)
    private String mensagem;

    @Column(name = "DATA_ENVIO", nullable = false)
    private LocalDateTime dataEnvio;
}
