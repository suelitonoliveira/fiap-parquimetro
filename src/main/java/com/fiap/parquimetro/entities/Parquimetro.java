package com.fiap.parquimetro.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
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
