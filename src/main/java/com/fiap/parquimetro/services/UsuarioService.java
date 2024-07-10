package com.fiap.parquimetro.services;

import com.fiap.parquimetro.dto.UsuarioDTO;
import com.fiap.parquimetro.entities.Endereco;
import com.fiap.parquimetro.entities.Usuario;
import com.fiap.parquimetro.exceptions.RecursoNaoEncontradoException;
import com.fiap.parquimetro.mapper.UsuarioMapper;
import com.fiap.parquimetro.repositories.EnderecoRepository;
import com.fiap.parquimetro.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
        Endereco endereco = usuarioDTO.getEndereco();
        enderecoRepository.save(endereco);
        Usuario usuario = UsuarioMapper.toEntity(usuarioDTO);
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return UsuarioMapper.toDTO(savedUsuario);
    }

    public UsuarioDTO buscaUsuarioPorId(Long id) {
        return this.usuarioRepository.findById(id)
                .map(UsuarioMapper::toDTO)
                .orElseThrow(() -> new RecursoNaoEncontradoException(String.format("Usuario com cod:%d não encontrado", id)));
    }

    @Transactional
    public UsuarioDTO atualizarUsuario(Long id, UsuarioDTO usuarioDTO) {
        // Carregar o usuário existente do banco de dados
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Atualizar os campos do usuário com base no DTO
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setCpf(usuarioDTO.getCpf());
        usuario.setTelefone(usuarioDTO.getTelefone());
        usuario.setVeiculos(usuarioDTO.getVeiculos());
        usuario.setTipoUsuario(usuarioDTO.getTipoUsuario());

        Endereco endereco = enderecoRepository.findById(usuarioDTO.getEndereco().getId())
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));

        endereco.setLogradouro(usuarioDTO.getEndereco().getLogradouro());
        endereco.setNumero(usuarioDTO.getEndereco().getNumero());
        endereco.setComplemento(usuarioDTO.getEndereco().getComplemento());
        endereco.setCidade(usuarioDTO.getEndereco().getCidade());
        endereco.setEstado(usuarioDTO.getEndereco().getEstado());
        endereco.setCep(usuarioDTO.getEndereco().getCep());


        usuario.setEndereco(endereco);
        usuario.setDataDeAlteracao(LocalDateTime.now());

        Usuario savedUsuario = usuarioRepository.save(usuario);
        return UsuarioMapper.toDTO(savedUsuario);
    }

    public void deletaUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

}






