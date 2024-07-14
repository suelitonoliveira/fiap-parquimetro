package com.fiap.parquimetro.controller;

import com.fiap.parquimetro.dto.PagamentoDTO;
import com.fiap.parquimetro.dto.SessaoDTO;
import com.fiap.parquimetro.entities.Sessao;
import com.fiap.parquimetro.services.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessoes")
public class SessaoController {
    @Autowired
    private SessaoService sessaoService;

    @PostMapping("/iniciar")
    public ResponseEntity<Sessao> iniciarSessao(@RequestParam Long usuarioId,
                                                @RequestParam Long parquimetroId,
                                                @RequestBody PagamentoDTO pagamentoDTO) {
        Sessao sessao = sessaoService.iniciarSessao(usuarioId, parquimetroId, pagamentoDTO);
        return ResponseEntity.ok(sessao);
    }
}
