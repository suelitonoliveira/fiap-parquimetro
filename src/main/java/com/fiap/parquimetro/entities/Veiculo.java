package com.fiap.parquimetro.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_veiculo", schema = "parquimetro")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    private Long id;

    @Column(name = "PLACA", nullable = false)
    private String placa;

    @Column(name = "MODELO", nullable = false)
    private String modelo;

    @Column(name = "MARCA", nullable = false)
    private String marca;

    @ManyToOne
    @JoinColumn(name="CONDUTOR_ID", nullable = false)
    private Usuario usuario;

}
