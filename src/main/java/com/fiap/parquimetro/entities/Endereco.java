package com.fiap.parquimetro.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_endereco", schema = "parquimetro")
@Data
public class Endereco extends Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    private Long id;

    @Column(name = "LOGRADOURO", nullable = false, length = 100)
    private String logradouro;

    @Column(name = "NUMERO", nullable = false, length = 10)
    private Integer numero;

    @Column(name = "COMPLEMENTO", nullable = false, length = 50)
    private String complemento;

    @Column(name = "CIDADE", nullable = false, length = 50)
    private String cidade;

    @Column(name = "ESTADO", nullable = false, length = 2)
    private String estado;

    @Column(name = "CEP", nullable = false, length = 8)
    private String cep;


}
