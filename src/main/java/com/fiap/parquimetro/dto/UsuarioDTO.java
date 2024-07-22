package com.fiap.parquimetro.dto;

import com.fiap.parquimetro.entities.Endereco;
import com.fiap.parquimetro.entities.Usuario;
import com.fiap.parquimetro.entities.Veiculo;
import com.fiap.parquimetro.enums.TipoUsuario;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UsuarioDTO {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long usuarioId;

    @NotBlank(message = "Campo nome obrigatório")
    private String nome;

    @NotBlank(message = "Campo codEndereco obrigatório")
    private Long codEndereco;

    @NotBlank(message = "Campo cpf obrigatório")
    private String cpf;

    @NotBlank(message = "Campo email obrigatório")
    private String email;

    @NotBlank(message = "Campo telefone obrigatório")
    private String telefone;

    @NotNull(message = "Campo tipoUsuario obrigatório")
    public TipoUsuario tipoUsuario;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    public List<Veiculo> listaVeiculo;

}