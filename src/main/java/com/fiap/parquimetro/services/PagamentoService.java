package com.fiap.parquimetro.services;

import com.fiap.parquimetro.dto.PagamentoDTO;
import com.fiap.parquimetro.dto.ParquimetroDTO;
import com.fiap.parquimetro.dto.SessaoDTO;
import com.fiap.parquimetro.dto.UsuarioDTO;
import com.fiap.parquimetro.entities.Pagamento;
import com.fiap.parquimetro.entities.Parquimetro;
import com.fiap.parquimetro.entities.Sessao;
import com.fiap.parquimetro.enums.TipoUsuario;
import com.fiap.parquimetro.exceptions.RecursoNaoEncontradoException;
import com.fiap.parquimetro.mapper.PagamentoMapper;
import com.fiap.parquimetro.mapper.ParquimetroMapper;
import com.fiap.parquimetro.repositories.PagamentoRepository;
import com.fiap.parquimetro.repositories.ParquimetroRepository;
import com.fiap.parquimetro.repositories.SessaoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    private final UsuarioService usuarioService;
    private final SessaoRepository sessaoRepository;

    @Transactional(rollbackOn = Exception.class)
    public PagamentoDTO realizarPagamento(@Valid PagamentoDTO pagamentoDTO) {
        UsuarioDTO usuario = usuarioService.buscaUsuarioPorId(pagamentoDTO.getCodUsuario());
        validarTipoUsuario(usuario.tipoUsuario);
        Sessao sessaoUsuario =
                sessaoRepository.findByUsuario_UsuarioId(pagamentoDTO.getCodUsuario())
                        .orElseThrow(() -> new RecursoNaoEncontradoException(String.format("Usuário com cod:%d não possui sessão",
                                        pagamentoDTO.getCodUsuario())));
        Pagamento pagamento =  PagamentoMapper.toEntity(pagamentoDTO,sessaoUsuario);

        return PagamentoMapper.toDTO(pagamentoRepository.save(pagamento));
    }

    private void validarTipoUsuario(TipoUsuario tipoUsuario) {
        if (!tipoUsuario.equals(TipoUsuario.CONDUTOR)) {
            throw new RuntimeException(String.format("Usuário tipo:%d não pode realizar pagamento", tipoUsuario));
        }
    }

}
