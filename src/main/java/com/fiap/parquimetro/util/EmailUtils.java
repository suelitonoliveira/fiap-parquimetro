package com.fiap.parquimetro.util;

import com.fiap.parquimetro.entities.Recibo;
import com.fiap.parquimetro.entities.Sessao;
import com.fiap.parquimetro.entities.Usuario;
import com.fiap.parquimetro.entities.Veiculo;

public class EmailUtils {
    public static final String subjectComprovante = "🅿️ Parquímetros - Aqui seu comprovante 🧾";
    public static final String subjectTempoLimite = "🅿️ Parquímetros - ‼️ATENÇÃO‼️";
    public static final String subjectCadastroUsuario = "🅿️ Parquímetros - Hora de Estacionar Inteligente 🧠";
    public static final String subjectCadastroVeiculo = "🅿️ Parquímetros - Mais um pra conta 🆙";

    public static final String bodyComprovante(Recibo recibo){
        StringBuilder sb = new StringBuilder();
        sb.append("Seu pagamento foi realizado com sucesso! Segue seu recibo:");
        sb.append(" \n Código do recibo: ").append(recibo.getId());
        sb.append(" \n Tempo Estacionado: ").append(recibo.getTempoEstacionado());
        sb.append(" \n Tarifa Aplicada: ").append(recibo.getTarifaAplicada());
        sb.append(" \n Valor pago: ").append(recibo.getValorPago());
        sb.append(" \n Data de emissão: ").append(recibo.getDataEmissao());
        sb.append(" \n Inicio de Sessão:").append(recibo.getSessao().getInicioSessao());
        sb.append(" \n Fim de Sessão:").append(recibo.getSessao().getFimSessao());
        sb.append(" \n Nome:").append(recibo.getSessao().getUsuario().getNome());
        sb.append(" \n CPF:").append(recibo.getSessao().getUsuario().getCpf());
        return sb.toString();
    }

    public static final String bodyTempoLimite(Sessao sessao){
        StringBuilder sb = new StringBuilder();
        sb.append(sessao.getUsuario().getNome());
        sb.append(", sua sessão está prestes à expirar!" +
                "Para não ficar sujeito à multa, retire seu veículo do local ou realize outra sessão!");
        return sb.toString();
    }

    public static final String bodyCadastroUsuario(Usuario usuario){
    StringBuilder sb = new StringBuilder();
    sb.append("Seja muito bem vindo ").append(usuario.getNome());
    sb.append(". É um prazer te receber aqui ❤️").append("\n - 🅿️ Parquímetros");
    return sb.toString();
    }

    public static final String bodyCadastroVeiculo(Veiculo veiculo){
        StringBuilder sb = new StringBuilder();
        sb.append("Seu novo veículo ").append(veiculo.getMarca());
        sb.append(" ").append(veiculo.getModelo());
        sb.append(" de placa final ").append(veiculo.getPlaca().substring(4));
        sb.append(" foi registrado com sucesso! Parabéns!");
        return sb.toString();
    }

}
