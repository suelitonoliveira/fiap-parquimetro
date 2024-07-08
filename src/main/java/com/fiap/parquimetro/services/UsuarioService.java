package com.fiap.parquimetro.services;

import com.fiap.parquimetro.entities.Usuario;
import com.fiap.parquimetro.entities.Endereco;
import com.fiap.parquimetro.exceptions.RecursoNaoEncontradoException;
import com.fiap.parquimetro.repositories.UsuarioRepository;
import com.fiap.parquimetro.repositories.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;

    private final EnderecoRepository enderecoRepository;

    public List<Usuario> listarTodos() {
        return this.usuarioRepository.findAll();
    }

    @Transactional
    public Usuario salvar(Usuario usuario) {
        Endereco endereco = usuario.getEndereco();
        enderecoRepository.save(endereco);
        return this.usuarioRepository.save(usuario);
    }

    public Usuario buscaUsuarioPorId(Long codUsuario) {
        return this.usuarioRepository.findById(codUsuario)
                .orElseThrow(() -> new RecursoNaoEncontradoException(String.format("Usuario com cod:%d não encontrado", codUsuario)));
    }

    public Usuario atualizarUsuario(Long id, Usuario usuario) {
        usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado"));
        return usuarioRepository.save(usuario);
    }


}


