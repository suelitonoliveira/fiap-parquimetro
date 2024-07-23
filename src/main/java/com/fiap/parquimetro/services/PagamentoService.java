package com.fiap.parquimetro.services;

import com.fiap.parquimetro.dto.PagamentoDTO;
import com.fiap.parquimetro.dto.UsuarioDTO;
import com.fiap.parquimetro.entities.Pagamento;
import com.fiap.parquimetro.entities.Recibo;
import com.fiap.parquimetro.entities.Sessao;
import com.fiap.parquimetro.enums.StatusPagamento;
import com.fiap.parquimetro.enums.TipoUsuario;
import com.fiap.parquimetro.exceptions.RecursoNaoEncontradoException;
import com.fiap.parquimetro.mapper.PagamentoMapper;
import com.fiap.parquimetro.repositories.PagamentoRepository;
import com.fiap.parquimetro.repositories.ReciboRepository;
import com.fiap.parquimetro.repositories.SessaoRepository;
import com.fiap.parquimetro.util.EmailUtils;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;
    private final UsuarioService usuarioService;
    private final SessaoRepository sessaoRepository;
    private final NotificacaoService notificacaoService;
    private final ReciboRepository reciboRepository;

    private final BigDecimal TARIFA_APLICADA = BigDecimal.valueOf(10);

    @Transactional(rollbackOn = Exception.class)
    public PagamentoDTO realizarPagamento(@Valid PagamentoDTO pagamentoDTO) {
        UsuarioDTO usuario = usuarioService.buscaUsuarioPorId(pagamentoDTO.getCodUsuario());
        validarTipoUsuario(usuario.tipoUsuario);
        Sessao sessao =
                sessaoRepository.findByIdAndUsuario_UsuarioId(pagamentoDTO.getCodSessao(), pagamentoDTO.getCodUsuario())
                        .orElseThrow(() -> new RecursoNaoEncontradoException(String.format("Sessão com cod:%d não existe para esse usuário",
                                pagamentoDTO.getCodSessao())));
        Pagamento pagamento = PagamentoMapper.toEntity(pagamentoDTO, sessao);
        sessao.setStatusPagamento(StatusPagamento.PAGO);
        sessaoRepository.save(sessao);
        PagamentoDTO pagamentoRealizado = PagamentoMapper.toDTO(pagamentoRepository.save(pagamento));
        if (Objects.nonNull(pagamentoRealizado)) {
            var recibo = Recibo
                    .builder()
                    .sessao(sessao)
                    .dataEmissao(LocalDateTime.now())
                    .tarifaAplicada(TARIFA_APLICADA)
                    .valorPago(pagamentoDTO.getValor())
                    .tempoEstacionado(extrairTempoEstacionado(sessao))
                    .build();
            reciboRepository.saveAndFlush(recibo);
            notificacaoService.enviarNotificacao(sessao, EmailUtils.bodyComprovante(recibo), EmailUtils.subjectComprovante);
        }
        return pagamentoRealizado;
    }

    private String extrairTempoEstacionado(Sessao sessao) {
        LocalDateTime inicio = sessao.getInicioSessao();
        LocalDateTime fim = sessao.getFimSessao();

        Duration duracao = Duration.between(inicio, fim);

        long horas = duracao.toHours();
        long minutos = duracao.toMinutes() % 60;
        long segundos = duracao.getSeconds() % 60;

        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }

    private void validarTipoUsuario(TipoUsuario tipoUsuario) {
        if (!tipoUsuario.equals(TipoUsuario.CONDUTOR)) {
            throw new RuntimeException("Usuário não é do tipo Condutor");
        }
    }

}
