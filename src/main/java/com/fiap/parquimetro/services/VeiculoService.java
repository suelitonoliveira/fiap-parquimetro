package com.fiap.parquimetro.services;

import com.fiap.parquimetro.dto.ParquimetroDTO;
import com.fiap.parquimetro.dto.VeiculoDto;
import com.fiap.parquimetro.entities.Usuario;
import com.fiap.parquimetro.entities.Veiculo;
import com.fiap.parquimetro.enums.TipoUsuario;
import com.fiap.parquimetro.mapper.ParquimetroMapper;
import com.fiap.parquimetro.mapper.UsuarioMapper;
import com.fiap.parquimetro.mapper.VeiculoMapper;
import com.fiap.parquimetro.repositories.UsuarioRepository;
import com.fiap.parquimetro.repositories.VeiculosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private final UsuarioRepository usuarioRepository;

    private final VeiculosRepository veiculosRepository;

    public VeiculoDto cadastrarVeiculo (VeiculoDto veiculoDto){

        Usuario usuario = usuarioRepository.findById(veiculoDto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        if (!usuario.getTipoUsuario().equals(TipoUsuario.CONDUTOR)) {
            throw new RuntimeException("Usuario não é do tipo condutor");
        }

        Veiculo veiculo = veiculosRepository.findByPlacaIgnoreCase(veiculoDto.getNumeroPlaca())
                .orElseThrow(() -> new RuntimeException("Veiculo ja cadastrado"));

        Veiculo cadastroVeiculo = VeiculoMapper.toEntity(veiculoDto, UsuarioMapper.toDTO(usuario));
        return VeiculoMapper.toDTO(veiculo);
    }
    public List<VeiculoDto> listarVeiculos() {
        return veiculosRepository.findAll().stream().map(VeiculoMapper::toDTO).toList();
    }
}
