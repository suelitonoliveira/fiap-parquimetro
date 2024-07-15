package com.fiap.parquimetro.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fiap.parquimetro.enums.StatusPagamento;
import com.fiap.parquimetro.util.ValidacaoDataFim;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@ValidacaoDataFim
public class SessaoDTO {


    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotNull( message = "Campo usuarioId obrigatório")
    private Long usuarioId;

    @NotNull( message = "Campo usuarioId obrigatório")
    private Long parquimetroId;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime inicioSessao;

    @NotNull( message = "Campo usuarioId obrigatório")
    private LocalDateTime fimSessao;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private StatusPagamento statusPagamento;
}
