package com.fiap.parquimetro.controller;

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

    @Operation(summary = "Cadastra Novo Usuário do Tipo Condutor", tags = "Usuário")
    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {
        if (usuario.getEndereco() == null) {
            return ResponseEntity.badRequest().body(null);
        }
        Usuario cadastrarUsuario = usuarioService.salvar(usuario);

        return ResponseEntity.ok(cadastrarUsuario);
    }

}
