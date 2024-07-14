package com.fiap.parquimetro.controller;

import com.fiap.parquimetro.dto.UsuarioDTO;
import com.fiap.parquimetro.entities.Usuario;
import com.fiap.parquimetro.exceptions.RecursoNaoEncontradoException;
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
        if (usuarioDTO.getEndereco() == null) {
            return ResponseEntity.badRequest().body(null);
        }
        UsuarioDTO cadastrarUsuario = usuarioService.salvar(usuarioDTO);
        return ResponseEntity.ok(cadastrarUsuario);
    }


    /*@Operation(summary = "Atualiza Usuario existente", tags = "Usuário")
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO updatedUsuario = usuarioService.atualizarUsuario(id, usuarioDTO);
        return ResponseEntity.ok(updatedUsuario);
    }

    @Operation(summary = "Deleta o Usuario passando o ID", tags = "Usuário")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaUsuario(@PathVariable Long id) {
        usuarioService.deletaUsuario(id);
        return ResponseEntity.noContent().build();
    }*/

}
