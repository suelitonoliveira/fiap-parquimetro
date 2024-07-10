package com.fiap.parquimetro.controller;

import com.fiap.parquimetro.dto.SessaoDTO;
import com.fiap.parquimetro.entities.Sessao;
import com.fiap.parquimetro.services.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessoes")
public class SessaoController {
    @Autowired
    private SessaoService sessaoService;

    @PostMapping("/iniciar")
    public Sessao iniciarSessao(@RequestBody SessaoDTO sessaoDTO){
        return sessaoService.iniciarSessao(sessaoDTO.getUsuarioId(), sessaoDTO.getParquimetroId());
    }
}
