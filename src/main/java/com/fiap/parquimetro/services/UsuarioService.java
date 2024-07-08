package com.fiap.parquimetro.services;

import com.fiap.parquimetro.dto.UsuarioDTO;
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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;

    private final EnderecoRepository enderecoRepository;

    public List<UsuarioDTO> listarTodos() {
        List<Usuario> usuarios = this.usuarioRepository.findAll();
        return usuarios.stream().map(Usuario::toDTO).collect(Collectors.toList());
    }

    @Transactional
    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        Endereco endereco = usuarioDTO.getEndereco();
        enderecoRepository.save(endereco);
        Usuario usuario = Usuario.toEntity(usuarioDTO);
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return savedUsuario.toDTO(savedUsuario);
    }

    public UsuarioDTO buscaUsuarioPorId(Long id) {
        return this.usuarioRepository.findById(id)
                .map(Usuario::toDTO)
                .orElseThrow(() -> new RecursoNaoEncontradoException(String.format("Usuario com cod:%d não encontrado", id)));
    }

    public UsuarioDTO atualizarUsuario(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado"));
        usuarioExistente.setNome(usuarioDTO.getNome());
        usuarioExistente.setEndereco(usuarioDTO.getEndereco());
        usuarioExistente.setCpf(usuarioDTO.getCpf());
        usuarioExistente.setEmail(usuarioDTO.getEmail());
        usuarioExistente.setTelefone(usuarioDTO.getTelefone());
        usuarioExistente.setTipoUsuario(usuarioDTO.getTipoUsuario());
        Usuario updatedUsuario = usuarioRepository.save(usuarioExistente);
        return updatedUsuario.toDTO(updatedUsuario);
    }


    public void deletaUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

}


