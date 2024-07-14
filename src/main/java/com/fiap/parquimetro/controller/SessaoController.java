package com.fiap.parquimetro.controller;

import com.fiap.parquimetro.dto.PagamentoDTO;
import com.fiap.parquimetro.dto.SessaoDTO;
import com.fiap.parquimetro.entities.Sessao;
import com.fiap.parquimetro.services.SessaoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessoes")
public class SessaoController {
    @Autowired
    private SessaoService sessaoService;

    @Operation(summary = "Inicia Sessao com status Pendente Pagamento", tags = "Sessao")
    @PostMapping("/iniciar")
    public ResponseEntity<Sessao> iniciarSessao(@RequestParam Long usuarioId,
                                                @RequestParam Long parquimetroId) {
        Sessao sessao = sessaoService.iniciarSessao(usuarioId, parquimetroId);
        return ResponseEntity.ok(sessao);
    }

    @Operation(summary = "Consulta pagamento e se ok, altera status para Pago", tags = "Sessao")
    @GetMapping("/{sessaoId}/consultar-pagamento")
    public ResponseEntity<String>consultarPagamento(@PathVariable Long sessaoId){
        try{
            sessaoService.consultarPagamento(sessaoId);
            return ResponseEntity.ok("Pagamento efetuado e sessao atualizada");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
