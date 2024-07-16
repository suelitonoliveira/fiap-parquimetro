package com.fiap.parquimetro.dto;

import com.fiap.parquimetro.enums.TipoPagamento;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PagamentoDTO {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @NotNull(message = "Campo tipoPagamento obrigatório")
    @Parameter(description = "Tipo de pagamento", schema = @Schema(implementation = TipoPagamento.class))
    private TipoPagamento tipoPagamento;

    @NotNull(message = "Campo codUsuario obrigatório")
    private Long codUsuario;

    @NotNull(message = "Campo valor obrigatório")
    private BigDecimal valor;

    @NotNull(message = "Campo codSessao obrigatório")
    private Long codSessao;

}
