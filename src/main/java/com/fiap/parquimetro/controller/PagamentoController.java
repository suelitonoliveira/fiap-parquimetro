package com.fiap.parquimetro.controller;

import com.fiap.parquimetro.dto.PagamentoDTO;
import com.fiap.parquimetro.services.PagamentoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "pagamentos")
@RequiredArgsConstructor
public class PagamentoController {

    private final PagamentoService pagamentoService;

    @Operation(summary = "Efetuar pagamento", tags = "Pagamento")
    @PostMapping
    public ResponseEntity<PagamentoDTO> pagamento(@RequestBody @Valid PagamentoDTO pagamentoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoService.realizarPagamento(pagamentoDTO));
    }

}
