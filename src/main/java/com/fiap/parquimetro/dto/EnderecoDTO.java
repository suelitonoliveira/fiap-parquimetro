package com.fiap.parquimetro.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotBlank(message = "Campo logradouro obrigatório")
    private String logradouro;

    @NotNull(message = "Campo numero obrigatório")
    private Integer numero;

    @NotBlank(message = "Campo complemento obrigatório")
    @Size(max = 50, message = "O campo cidade deve ter no máximo 50 caracteres")
    private String complemento;

    @NotBlank(message = "Campo cidade obrigatório")
    @Size(max = 50, message = "O campo cidade deve ter no máximo 50 caracteres")
    private String cidade;

    @NotBlank(message = "Campo estado obrigatório")
    @Size(max = 2, message = "O campo estado deve ter no máximo 2 caracteres")
    @Schema(description = "Estado representado por sua sigla", example = "SP", required = true)
    private String estado;

    @NotBlank(message = "Campo cep obrigatório")
    @Size(max = 8, message = "O campo cep deve ter no máximo 8 caracteres")
    private String cep;

    @NotNull(message = "Campo codUsuario obrigatório")
    private Long codUsuario;


}