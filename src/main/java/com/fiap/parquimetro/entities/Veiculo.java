package com.fiap.parquimetro.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_veiculo", schema = "parquimetro")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    private Long id;

    @Column(name = "PLACA")
    private String placa;

    @Column(name = "MODELO")
    private String modelo;

    @Column(name = "MARCA")
    private String marca;

    @ManyToOne
    @JoinColumn(name="CONDUTOR_ID")
    private Usuario usuario;


}
