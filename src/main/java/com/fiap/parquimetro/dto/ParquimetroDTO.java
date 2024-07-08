package com.fiap.parquimetro.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParquimetroDTO {

    private Long id;

    @NotBlank(message = "Campo numeroSerie obrigatório")
    private String numeroSerie;

    @NotBlank(message = "Campo modelo obrigatório")
    private String modelo;

    @NotNull(message = "Campo codUsuario obrigatório")
    private Long codUsuario;
}
