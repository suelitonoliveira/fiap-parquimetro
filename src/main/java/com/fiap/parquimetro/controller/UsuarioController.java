package com.fiap.parquimetro.controller;

import com.fiap.parquimetro.dto.EnderecoDTO;
import com.fiap.parquimetro.dto.UsuarioDTO;
import com.fiap.parquimetro.services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Operation(summary = "Lista todos os usuarios", tags = "Usuário")
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarTodos() {
        List<UsuarioDTO> usuarios = usuarioService.listarTodos();
        return ResponseEntity.ok(usuarios);
    }


    @Operation(summary = "Busca Usuario por Id", tags = "Usuário")
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscaUsuarioPorId(@PathVariable Long id) {
        UsuarioDTO usuarioDTO = usuarioService.buscaUsuarioPorId(id);
        return ResponseEntity.ok(usuarioDTO);
    }

    @Operation(summary = "Cadastra Novo Usuário", tags = "Usuário")
    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO cadastrarUsuario = usuarioService.salvar(usuarioDTO);
        return ResponseEntity.ok(cadastrarUsuario);
    }

    @Operation(summary = "Lista todos os condutores", tags = "Usuário")
    @GetMapping("/condutores")
    public ResponseEntity<List<UsuarioDTO>> listarCondutores() {
        List<UsuarioDTO> usuarios = usuarioService.listarCondutores();
        return ResponseEntity.ok(usuarios);
    }

    @Operation(summary = "Cadastra Endereço para um usuario", tags = "Usuário")
    @PostMapping("/endereco")
    public ResponseEntity<EnderecoDTO> cadastrarEndereco(@RequestBody EnderecoDTO enderecoDTO) {
        EnderecoDTO enderecoUsuario = usuarioService.cadastrarEndereco(enderecoDTO);
        return ResponseEntity.ok(enderecoUsuario);
    }

}
