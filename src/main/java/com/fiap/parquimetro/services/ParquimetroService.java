package com.fiap.parquimetro.services;

import com.fiap.parquimetro.dto.ParquimetroDTO;
import com.fiap.parquimetro.dto.UsuarioDTO;
import com.fiap.parquimetro.entities.Parquimetro;
import com.fiap.parquimetro.entities.Veiculo;
import com.fiap.parquimetro.enums.TipoUsuario;
import com.fiap.parquimetro.mapper.ParquimetroMapper;
import com.fiap.parquimetro.repositories.ParquimetroRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParquimetroService {

    private final ParquimetroRepository parquimetroRepository;
    private final UsuarioService usuarioService;
    private final VeiculoService veiculoService;


    @Transactional(rollbackOn = Exception.class)
    public ParquimetroDTO salvar(ParquimetroDTO parquimetroDTO) {
        UsuarioDTO usuario = usuarioService.buscaUsuarioDtoPorId(parquimetroDTO.getCodUsuario());
        if (!usuario.tipoUsuario.equals(TipoUsuario.ADMIN_SISTEMA)) {
            throw new RuntimeException("Usuário não é do tipo ADMIN_SISTEMA");
        }
        List<Veiculo> listaVeiculo = veiculoService.listarPorCpfUsuario(usuario.getCpf());
        ;
        Parquimetro novoParquimetro = parquimetroRepository.findByNumeroSerieIgnoreCase(parquimetroDTO.getNumeroSerie())
                .map(parquimetroExistente -> ParquimetroMapper.updateEntity(parquimetroExistente, parquimetroDTO, usuario))
                .orElseGet(() -> ParquimetroMapper.toEntity(parquimetroDTO, usuario));
        return ParquimetroMapper.toDTO(parquimetroRepository.save(novoParquimetro));
    }

    public List<ParquimetroDTO> listarTodos() {
        return parquimetroRepository.findAll().stream().map(ParquimetroMapper::toDTO).toList();
    }
}
