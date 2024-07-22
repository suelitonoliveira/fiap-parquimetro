package com.fiap.parquimetro.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    private String complemento;

    @NotBlank(message = "Campo cidade obrigatório")
    private String cidade;

    @NotBlank(message = "Campo estado obrigatório")
    private String estado;

    @NotBlank(message = "Campo cep obrigatório")
    private String cep;


}