package com.fiap.parquimetro.controller;

import com.fiap.parquimetro.dto.UsuarioDTO;
import com.fiap.parquimetro.entities.Usuario;
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
    public ResponseEntity<List<Usuario>> listarTodos() {
        List<Usuario> usuarios = this.usuarioService.listarTodos();
        return ResponseEntity.ok(usuarios);
    }

    @Operation(summary = "Cadastra Novo Usuário", tags = "Usuário")
    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody UsuarioDTO usuarioDTO) {
        if (usuarioDTO.getEndereco() == null) {
            return ResponseEntity.badRequest().body(null);
        }
        UsuarioDTO cadastrarUsuario = usuarioService.salvar(usuarioDTO);
        return ResponseEntity.ok(cadastrarUsuario);


   }

}
