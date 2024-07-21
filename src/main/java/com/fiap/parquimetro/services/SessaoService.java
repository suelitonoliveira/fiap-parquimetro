package com.fiap.parquimetro.services;

import com.fiap.parquimetro.dto.SessaoDTO;
import com.fiap.parquimetro.entities.Parquimetro;
import com.fiap.parquimetro.entities.Sessao;
import com.fiap.parquimetro.entities.Usuario;
import com.fiap.parquimetro.enums.StatusPagamento;
import com.fiap.parquimetro.enums.TipoUsuario;
import com.fiap.parquimetro.mapper.SessaoMapper;
import com.fiap.parquimetro.repositories.ParquimetroRepository;
import com.fiap.parquimetro.repositories.SessaoRepository;
import com.fiap.parquimetro.repositories.UsuarioRepository;
import com.fiap.parquimetro.util.EmailUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SessaoService {

    private final SessaoRepository sessaoRepository;

    private final UsuarioRepository usuarioRepository;

    private final ParquimetroRepository parquimetroRepository;

    private final NotificacaoService notificacaoService;


    public List<SessaoDTO> listar(Boolean expiradas, Boolean pagas) {

        if (Boolean.TRUE.equals(expiradas)) {
            return listarExpiradas();
        }
        if (Boolean.TRUE.equals(pagas)) {
            return listarSessoesPagas();
        }

        return sessaoRepository.findAll().stream().map(SessaoMapper::toDTO).toList();
    }

    private List<SessaoDTO> listarSessoesPagas() {
        List<Sessao> sessoesPagas = sessaoRepository.findAll(Example.of(Sessao.builder().statusPagamento(StatusPagamento.PAGO).build()));
        return sessoesPagas.stream()
                .map(SessaoMapper::toDTO)
                .toList();
    }

    private List<SessaoDTO> listarExpiradas() {
        LocalDateTime agora = LocalDateTime.now();
        List<Sessao> sessoesExpiradas = sessaoRepository.findByFimSessaoBefore(agora);
        return sessoesExpiradas.stream()
                .map(SessaoMapper::toDTO)
                .toList();
    }

    public SessaoDTO iniciarSessao(SessaoDTO sessaoDTO) {
        Usuario usuario = usuarioRepository.findById(sessaoDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        if (!usuario.getTipoUsuario().equals(TipoUsuario.CONDUTOR)) {
            throw new RuntimeException("Usuario não é do tipo condutor");
        }

        Parquimetro parquimetro = parquimetroRepository.findById(sessaoDTO.getParquimetroId())
                .orElseThrow(() -> new RuntimeException("Parquimetro não encontrado"));

        Sessao sessaoSalva = sessaoRepository.save(SessaoMapper.toEntity(sessaoDTO, parquimetro, usuario));

        return SessaoMapper.toDTO(sessaoSalva);
    }

    @Scheduled(fixedRate = 30000)
    private void notificarSessoesPendentes(){
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime faltante = agora.plusMinutes(10);

        List<Sessao> sessoesPendentes = sessaoRepository.findByStatusPagamentoAndFimSessaoBefore(
                StatusPagamento.PENDENTE, faltante);

        for (Sessao sessao : sessoesPendentes) {
            notificacaoService.enviarNotificacao(sessao, EmailUtils.bodyTempoLimite(sessao), EmailUtils.subjectTempoLimite);
        }
    }

}
