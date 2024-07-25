package com.fiap.parquimetro.services;

import com.fiap.parquimetro.dto.UsuarioDTO;
import com.fiap.parquimetro.entities.Usuario;
import com.fiap.parquimetro.entities.Veiculo;
import com.fiap.parquimetro.enums.TipoUsuario;
import com.fiap.parquimetro.exceptions.DuplicateCpfException;
import com.fiap.parquimetro.exceptions.DuplicateEmailException;
import com.fiap.parquimetro.exceptions.RecursoNaoEncontradoException;
import com.fiap.parquimetro.mapper.UsuarioMapper;
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

    private final VeiculoService veiculoService;

    public List<UsuarioDTO> listarTodos() {
        List<Usuario> usuarios = this.usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioMapper::toDTO).collect(Collectors.toList());
    }

    @Transactional
    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {

        Usuario cpfExiste = usuarioRepository.findByCpf(usuarioDTO.getCpf());
        if (cpfExiste != null) {
            throw new DuplicateCpfException("CPF ja existe no banco de dados");
        } else {
            Usuario usuarioByEmail = usuarioRepository.findByEmail(usuarioDTO.getEmail());
            if (usuarioByEmail != null) {
                throw new DuplicateEmailException("Email já existe no banco de dados");
            } else {
                List<Veiculo> veiculos = veiculoService.listarPorCpfUsuario(usuarioDTO.getCpf());
                if (veiculos.isEmpty()) {
                    throw new RecursoNaoEncontradoException("Não há veículo cadastrado para esse usuário!");
                }
                Usuario usuario = UsuarioMapper.toEntity(usuarioDTO, veiculos);
                return UsuarioMapper.toDTO(usuarioRepository.save(usuario));
            }
        }

    }

    public UsuarioDTO buscaUsuarioDtoPorId(Long id) {
        return this.usuarioRepository.findById(id)
                .map(UsuarioMapper::toDTO)
                .orElseThrow(() -> new RecursoNaoEncontradoException(String.format("Usuario com cod:%d não encontrado", id)));
    }

    public Usuario buscaUsuarioPorId(Long id) {
        return this.usuarioRepository.findById(id)
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






