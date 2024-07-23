package com.fiap.parquimetro.services;

import com.fiap.parquimetro.dto.VeiculoDto;
import com.fiap.parquimetro.entities.Usuario;
import com.fiap.parquimetro.entities.Veiculo;
import com.fiap.parquimetro.enums.TipoUsuario;
import com.fiap.parquimetro.mapper.VeiculoMapper;
import com.fiap.parquimetro.repositories.UsuarioRepository;
import com.fiap.parquimetro.repositories.VeiculoRepository;
import com.fiap.parquimetro.util.PlacaValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private final UsuarioRepository usuarioRepository;

    private final VeiculoRepository veiculoRepository;

    public VeiculoDto cadastrarVeiculo(VeiculoDto veiculoDto) {

        boolean valid = PlacaValidator.isValid(veiculoDto.getPlaca());
        if (!valid) {
            throw new RuntimeException("Placa inválida!");
        }

        Usuario usuario = usuarioRepository.findById(veiculoDto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        if (!usuario.getTipoUsuario().equals(TipoUsuario.CONDUTOR)) {
            throw new RuntimeException("Usuario não é do tipo condutor");
        }
        Veiculo entity = VeiculoMapper.toEntity(veiculoDto, usuario);

        Veiculo veiculoSalvo = veiculoRepository.findByPlacaIgnoreCase(veiculoDto.getPlaca())
                .map(veiculoExistente -> VeiculoMapper.toUpdate(veiculoExistente, entity))
                .map(veiculoRepository::save)
                .orElseGet(() -> veiculoRepository.save(entity));


        return VeiculoMapper.toDTO(veiculoSalvo);
    }

    public List<VeiculoDto> listarVeiculos() {
        return veiculoRepository.findAll().stream().map(VeiculoMapper::toDTO).toList();
    }

    public List<Veiculo> listarPorCpfUsuario(String cpfUsuario) {
        return veiculoRepository.findDistinctByUsuario_Cpf(cpfUsuario);
    }
}