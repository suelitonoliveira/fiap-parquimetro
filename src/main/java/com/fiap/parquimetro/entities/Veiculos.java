package com.fiap.parquimetro.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "veiculos", schema = "parquimetro")
public class Veiculos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String modelo;
    private String marca;
    @ManyToOne
    @JoinColumn(name="condutor_id")
    private Condutor condutor;


}
