package com.fiap.parquimetro.services;

import com.fiap.parquimetro.entities.Veiculo;
import com.fiap.parquimetro.repositories.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeiculoService {
    private final VeiculoRepository veiculoRepository;

    public List<Veiculo> listarPorCpfUsuario(String cpfUsuario) {
        return veiculoRepository.findDistinctByUsuario_Cpf(cpfUsuario);
    }
}
