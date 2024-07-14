package com.fiap.parquimetro.services;

import com.fiap.parquimetro.dto.PagamentoDTO;
import com.fiap.parquimetro.entities.Pagamento;
import com.fiap.parquimetro.entities.Parquimetro;
import com.fiap.parquimetro.entities.Sessao;
import com.fiap.parquimetro.entities.Usuario;
import com.fiap.parquimetro.enums.StatusPagamento;
import com.fiap.parquimetro.enums.TipoUsuario;
import com.fiap.parquimetro.repositories.PagamentoRepository;
import com.fiap.parquimetro.repositories.ParquimetroRepository;
import com.fiap.parquimetro.repositories.SessaoRepository;
import com.fiap.parquimetro.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SessaoService {
    @Autowired
    private SessaoRepository sessaoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ParquimetroRepository parquimetroRepository;
    @Autowired
    private PagamentoService pagamentoService;
    @Autowired
    private PagamentoRepository pagamentoRepository;

    public SessaoService(UsuarioRepository usuarioRepository, ParquimetroRepository parquimetroRepository,
                         SessaoRepository sessaoRepository, PagamentoService pagamentoService) {
        this.usuarioRepository = usuarioRepository;
        this.parquimetroRepository = parquimetroRepository;
        this.sessaoRepository = sessaoRepository;
        this.pagamentoService = pagamentoService;
    }


    public Sessao iniciarSessao(Long usuarioId, Long id, PagamentoDTO pagamentoDTO) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        if (!usuario.getTipoUsuario().equals(TipoUsuario.CONDUTOR)) {
            throw new RuntimeException("Usuario não é do tipo condutor");
        }

        Parquimetro parquimetro = parquimetroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parquimetro não encontrado"));

        pagamentoDTO.setCodUsuario(usuarioId);
        PagamentoDTO pagamentoRealizado = pagamentoService.realizarPagamento(pagamentoDTO);

        Pagamento pagamento = pagamentoRepository.findById(pagamentoRealizado.getId())
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));

        if (pagamento.getStatusPagamento().equals(StatusPagamento.PAGO)) {
            Sessao sessao = new Sessao();
            sessao.setUsuario(usuario);
            sessao.setParquimetro(parquimetro);
            sessao.setInicioSessao(LocalDateTime.now());
            sessao.setStatusPagamento(StatusPagamento.PAGO);

            return sessaoRepository.save(sessao);
        } else {
            throw new RuntimeException("Pagamento não realizado com sucesso");
        }
    }
}
