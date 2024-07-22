package com.fiap.parquimetro.services;

import com.fiap.parquimetro.dto.EnderecoDTO;
import com.fiap.parquimetro.entities.Endereco;
import com.fiap.parquimetro.exceptions.RecursoNaoEncontradoException;
import com.fiap.parquimetro.mapper.EnderecoMapper;
import com.fiap.parquimetro.repositories.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;

    public Endereco buscarEnderecoPorId(Long id) {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(
                        String.format("Endereço com cod:%d não encontrado", id)));
    }

    public EnderecoDTO cadastrar(EnderecoDTO enderecoDTO) {
        Endereco endereco = enderecoRepository.save(EnderecoMapper.toEntity(enderecoDTO));
        return EnderecoMapper.toDto(endereco);
    }
}
