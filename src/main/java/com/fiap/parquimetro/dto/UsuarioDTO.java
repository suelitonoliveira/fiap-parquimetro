package com.fiap.parquimetro.dto;

import com.fiap.parquimetro.entities.Endereco;
import com.fiap.parquimetro.entities.Usuario;
import com.fiap.parquimetro.entities.Veiculo;
import com.fiap.parquimetro.enums.TipoUsuario;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UsuarioDTO {

    private Long usuarioId;

    private String nome;
    @NotBlank(message = "Campo Endereco obrigatório")
    private Endereco endereco;
    @NotBlank(message = "Campo cpf obrigatório")
    private String cpf;
    @NotBlank(message = "Campo email obrigatório")
    private String email;
    @NotBlank(message = "Campo telefone obrigatório")
    private String telefone;
    public List<Veiculo> veiculos;
    @NotBlank(message = "Campo tipoUsuario obrigatório")
    public TipoUsuario tipoUsuario;




}
