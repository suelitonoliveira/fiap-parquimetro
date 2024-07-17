package com.fiap.parquimetro.services;

import com.fiap.parquimetro.dto.UsuarioDTO;
import com.fiap.parquimetro.entities.Endereco;
import com.fiap.parquimetro.entities.Usuario;
import com.fiap.parquimetro.enums.TipoUsuario;
import com.fiap.parquimetro.exceptions.RecursoNaoEncontradoException;
import com.fiap.parquimetro.mapper.UsuarioMapper;
import com.fiap.parquimetro.repositories.EnderecoRepository;
import com.fiap.parquimetro.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;

    private final EnderecoRepository enderecoRepository;

    public List<UsuarioDTO> listarTodos() {
        List<Usuario> usuarios = this.usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioMapper::toDTO).collect(Collectors.toList());
    }

    @Transactional
    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        Usuario usuarioExistente = usuarioRepository.findByCpf(usuarioDTO.getCpf());
        if (usuarioExistente != null) {
            usuarioExistente.setNome(usuarioDTO.getNome());
            usuarioExistente.setEndereco(usuarioDTO.getEndereco());
            usuarioExistente.setEmail(usuarioDTO.getEmail());
            usuarioExistente.setTelefone(usuarioDTO.getTelefone());
            usuarioExistente.setTipoUsuario(usuarioDTO.getTipoUsuario());
            enderecoRepository.save(usuarioExistente.getEndereco());
            Usuario updateUsuario = usuarioRepository.save(usuarioExistente);
            return UsuarioMapper.toDTO(updateUsuario);
    }else {
        Endereco endereco = usuarioDTO.getEndereco();
        enderecoRepository.save(endereco);
        Usuario usuario = UsuarioMapper.toEntity(usuarioDTO);
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return UsuarioMapper.toDTO(savedUsuario);
    }
}

    public UsuarioDTO buscaUsuarioPorId(Long id) {
        return this.usuarioRepository.findById(id)
                .map(UsuarioMapper::toDTO)
                .orElseThrow(() -> new RecursoNaoEncontradoException(String.format("Usuario com cod:%d não encontrado", id)));
    }


    public List<UsuarioDTO> listarCondutores() {
        List<Usuario> usuarios = this.usuarioRepository.findAll(
                Example.of(Usuario
                        .builder()
                        .tipoUsuario(TipoUsuario.CONDUTOR)
                        .build()));
        return usuarios.stream().map(UsuarioMapper::toDTO).toList();
    }
}






