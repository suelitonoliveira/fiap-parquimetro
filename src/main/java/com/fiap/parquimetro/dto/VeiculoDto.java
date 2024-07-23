package com.fiap.parquimetro.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fiap.parquimetro.enums.StatusPagamento;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotNull( message = "Campo usuarioId obrigatório")
    private Long usuarioId;

    @NotBlank(message = "Campo numeroPlaca obrigatório")
    private String numeroPlaca;

    @NotNull( message = "Campo modelo obrigatório")
    private String modelo;

    @NotNull( message = "Campo marca obrigatório")
    private String marca;

}
