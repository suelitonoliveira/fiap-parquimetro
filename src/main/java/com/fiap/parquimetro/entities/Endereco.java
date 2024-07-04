package com.fiap.parquimetro.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="endereco")
@Data
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;
    private Integer numero;
    private String complemento;
    private String cidade;
    private String estado;
    private String cep;


}
