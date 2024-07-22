package com.fiap.parquimetro.controller;

import com.fiap.parquimetro.dto.SessaoDTO;
import com.fiap.parquimetro.services.SessaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessoes")
@RequiredArgsConstructor
public class SessaoController {

    private final SessaoService sessaoService;

    @Operation(summary = "Inicia Sessao com status Pendente Pagamento", tags = "Sessao")
    @PostMapping("/iniciar")
    public ResponseEntity<SessaoDTO> iniciarSessao(@RequestBody @Valid SessaoDTO sessaoDTO) {
        return ResponseEntity.ok(sessaoService.iniciarSessao(sessaoDTO));
    }


    @Operation(summary = "Lista todas sessões", tags = "Sessao")
    @GetMapping
    public ResponseEntity<List<SessaoDTO>> listar(
            @Parameter(description = "Filtra sessões expiradas", required = false, schema = @Schema(defaultValue = "false"))
            @RequestParam(required = false, defaultValue = "false") Boolean expiradas,

            @Parameter(description = "Filtra sessões pagas", required = false, schema = @Schema(defaultValue = "false"))
            @RequestParam(required = false, defaultValue = "false") Boolean pagas
    ) {
        List<SessaoDTO> sessaoDTO = sessaoService.listar(expiradas, pagas);
        return ResponseEntity.ok(sessaoDTO);
    }
}
