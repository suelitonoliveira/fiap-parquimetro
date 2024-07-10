package com.fiap.parquimetro.controller;

import com.fiap.parquimetro.dto.ParquimetroDTO;
import com.fiap.parquimetro.entities.Usuario;
import com.fiap.parquimetro.services.ParquimetroService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "parquimetros")
@RequiredArgsConstructor
public class ParquimetroController {

    private final ParquimetroService parquimetroService;

    @Operation(summary = "Lista todos os parquímetro", tags = "Parquímetro")
    @GetMapping
    public ResponseEntity<List<ParquimetroDTO>> listarTodos() {
        List<ParquimetroDTO> listaParquimetro= this.parquimetroService.listarTodos();
        return ResponseEntity.ok(listaParquimetro);
    }

    @Operation(summary = "Cadastrar Novo parquímetro", tags = "Parquímetro")
    @PostMapping
    public ResponseEntity<ParquimetroDTO> cadastrar(@RequestBody @Valid ParquimetroDTO parquimetroDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(parquimetroService.salvar(parquimetroDTO));
    }

}
