package com.fiap.parquimetro.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name = "tb_parquimetro", schema = "parquimetro")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Parquimetro extends Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    private Long id;

    @Column(name = "NUMERO_SERIE", nullable = false, unique = true)
    private String numeroSerie;

    @Column(name = "MODELO", nullable = false)
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "USUARIO_COD")
    private Usuario usuario;

}
