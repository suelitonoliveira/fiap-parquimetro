package com.fiap.parquimetro.entities;

import com.fiap.parquimetro.enums.TipoUsuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@Table(name = "tb_usuario", schema = "parquimetro")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario extends Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD")
    private Long usuarioId;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "CPF", nullable = false, unique = true)
    private String cpf;

    @Column(name = "EMAIL", nullable = false, unique = true)
    @Email
    private String email;

    @Column(name = "TELEFONE", nullable = false)
    private String telefone;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    public List<Veiculo> veiculos;

    @Column(name = "TIPO_USUARIO", nullable = false)
    @Enumerated(EnumType.STRING)
    public TipoUsuario tipoUsuario;


}
