package com.fiap.parquimetro.services;

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
    private PagamentoRepository pagamentoRepository;


    public Sessao iniciarSessao(Long usuarioId, Long parquimetroId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        if (!usuario.getTipoUsuario().equals(TipoUsuario.CONDUTOR)) {
            throw new RuntimeException("Usuario não é do tipo condutor");
        }

        Parquimetro parquimetro = parquimetroRepository.findById(parquimetroId)
                .orElseThrow(() -> new RuntimeException("Parquimetro não encontrado"));

        boolean pagamentoEfetuado = pagamentoRepository.existsByUsuarioIdAndParquimetroIdAndStatus(
                usuarioId, parquimetroId, StatusPagamento.PAGO);

        if (!pagamentoEfetuado) {
            throw new RuntimeException("Pagamento não efetuado");
        }

        Sessao sessao = new Sessao();
        sessao.setUsuario(usuario);
        sessao.setParquimetro(parquimetro);
        sessao.setInicioSessao(LocalDateTime.now());
        sessao.setStatusPagamento(StatusPagamento.PAGO);

        return sessaoRepository.save(sessao);


    }
}
