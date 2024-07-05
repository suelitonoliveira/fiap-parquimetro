package com.fiap.parquimetro.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="endereco", schema = "parquimetro")
@Data
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "logradouro", length = 100)
    private String logradouro;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "complemento", length = 50)
    private String complemento;

    @Column(name = "cidade", length = 50)
    private String cidade;

    @Column(name = "estado", length = 2)
    private String estado;

    @Column(name = "cep", length = 8)
    private String cep;


}
