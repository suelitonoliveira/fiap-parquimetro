package com.fiap.parquimetro.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Table(name = "parquimetro", schema = "parquimetro")
@Data
public class Parquimetro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String localizacao;
    private String status;
    private Integer capacidadeVagas;
    private LocalDateTime dataInstalacao;
}
