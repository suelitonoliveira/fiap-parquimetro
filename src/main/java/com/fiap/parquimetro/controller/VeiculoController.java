package com.fiap.parquimetro.controller;

import com.fiap.parquimetro.dto.ParquimetroDTO;
import com.fiap.parquimetro.dto.VeiculoDto;
import com.fiap.parquimetro.services.ParquimetroService;
import com.fiap.parquimetro.services.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "veiculos")
@RequiredArgsConstructor
public class VeiculoController {

    private final VeiculoService veiculoService;

    @Operation(summary = "Lista todos os veiculos", tags = "Veiculo")
    @GetMapping
    public ResponseEntity<List<VeiculoDto>> listarTodos() {
        List<VeiculoDto> listaVeiculos= this.veiculoService.listarVeiculos();
        return ResponseEntity.ok(listaVeiculos);
    }

    @Operation(summary = "Cadastrar Novo veiculo", tags = "veiculo")
    @PostMapping
    public ResponseEntity<VeiculoDto> cadastrar(@RequestBody @Valid VeiculoDto veiculoDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoService.cadastrarVeiculo(veiculoDto));
    }

}
