package com.fiap.parquimetro.services;

import com.fiap.parquimetro.dto.ParquimetroDTO;
import com.fiap.parquimetro.dto.UsuarioDTO;
import com.fiap.parquimetro.entities.Parquimetro;
import com.fiap.parquimetro.entities.Usuario;
import com.fiap.parquimetro.mapper.ParquimetroMapper;
import com.fiap.parquimetro.repositories.ParquimetroRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParquimetroService {

    private final ParquimetroRepository parquimetroRepository;
    private final UsuarioService usuarioService;

    @Transactional(rollbackOn = Exception.class)
    public ParquimetroDTO salvar(ParquimetroDTO parquimetroDTO) {
        UsuarioDTO usuario = usuarioService.buscaUsuarioPorId(parquimetroDTO.getId());
        Parquimetro parquimetroSalvo = parquimetroRepository.save(ParquimetroMapper.toEntity(parquimetroDTO, usuario));
        return ParquimetroMapper.toDTO(parquimetroSalvo);
    }

}
