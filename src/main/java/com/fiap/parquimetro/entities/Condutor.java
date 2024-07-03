package com.fiap.parquimetro.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "condutores")
public class Condutor {
    @Id
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    @OneToMany(mappedBy = "condutor", cascade = CascadeType.ALL)
    public List<Veiculos> veiculos;


}
