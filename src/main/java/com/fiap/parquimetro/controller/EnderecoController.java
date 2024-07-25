package com.fiap.parquimetro.controller;

import com.fiap.parquimetro.dto.EnderecoDTO;
import com.fiap.parquimetro.dto.VeiculoDto;
import com.fiap.parquimetro.services.EnderecoService;
import com.fiap.parquimetro.services.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "enderecos")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;

    @Operation(summary = "Lista todos os endereços", tags = "Endereço")
    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> listarTodos() {
        List<EnderecoDTO> listaEnderecos= this.enderecoService.listarTodos();
        return ResponseEntity.ok(listaEnderecos);
    }

    @Operation(summary = "Cadastra Endereço", tags = "Endereço")
    @PostMapping
    public ResponseEntity<EnderecoDTO> cadastrarEndereco(@RequestBody EnderecoDTO enderecoDTO) {
        EnderecoDTO enderecoUsuario = enderecoService.cadastrar(enderecoDTO);
        return ResponseEntity.ok(enderecoUsuario);
    }

}
