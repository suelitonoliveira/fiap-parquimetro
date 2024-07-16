package com.fiap.parquimetro.services;

import com.fiap.parquimetro.entities.Notificacao;
import com.fiap.parquimetro.entities.Sessao;
import com.fiap.parquimetro.enums.TipoNotificacao;
import com.fiap.parquimetro.repositories.NotificacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NotificacaoService {

    private final NotificacaoRepository notificacaoRepository;


    public void enviarNotificacao(Sessao sessao, String mensagem) {
        var notificacao =
                Notificacao
                        .builder()
                        .mensagem(mensagem)
                        .tipoNotificacao(TipoNotificacao.EMAIL)
                        .dataEnvio(LocalDateTime.now())
                        .sessao(sessao)
                        .build();
        notificacaoRepository.save(notificacao);
    }


}






