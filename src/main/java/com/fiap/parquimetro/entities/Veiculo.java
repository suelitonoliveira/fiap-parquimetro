package com.fiap.parquimetro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "PLACA", nullable = false , unique = true)
    private String placa;

    @Column(name = "MODELO", nullable = false)
    private String modelo;

    @Column(name = "MARCA", nullable = false)
    private String marca;

    @ManyToOne
    @JoinColumn(name="CONDUTOR_ID", nullable = false)
    @JsonIgnore
    private Usuario usuario;

}
