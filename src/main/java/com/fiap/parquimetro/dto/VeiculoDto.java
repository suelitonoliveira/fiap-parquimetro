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
public class VeiculoDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotNull(message = "Campo usuarioId obrigatório")
    private Long usuarioId;

    @NotBlank(message = "Campo placa obrigatório")
    @Schema(
            description = "Placas aceitas: modelo Mercosul ex: (NBE-8F05) ou antigo ex: (JGY-4730). " +
                    "Regex para placas antigas: ^[A-Z]{3}-[0-9]{4}$. " +
                    "Regex para placas Mercosul: ^[A-Z]{3}-[0-9]{1}[A-Z]{1}[0-9]{2}$",
            pattern = "^[A-Z]{3}-[0-9]{4}$|^[A-Z]{3}-[0-9]{1}[A-Z]{1}[0-9]{2}$"
    )
    private String placa;

    @NotNull(message = "Campo modelo obrigatório")
    private String modelo;

    @NotNull(message = "Campo marca obrigatório")
    private String marca;

}
