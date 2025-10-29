package com.carlosruanpucrs.tc2_microservico_jud.service;


import com.carlosruanpucrs.tc2_microservico_jud.client.ContaClient;
import com.carlosruanpucrs.tc2_microservico_jud.client.response.ContaResponse;
import com.carlosruanpucrs.tc2_microservico_jud.client.response.ContaSaldoResponse;
import com.carlosruanpucrs.tc2_microservico_jud.mapper.JudMapper;
import com.carlosruanpucrs.tc2_microservico_jud.message.event.JudBloqueioConfirmacaoEvent;
import com.carlosruanpucrs.tc2_microservico_jud.message.event.JudBloqueioEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@RequiredArgsConstructor
@Service
public class JudService {

    private final ContaClient contaClient;

    public JudBloqueioConfirmacaoEvent processar(JudBloqueioEvent evento) {
        ContaResponse conta;
        ContaSaldoResponse contaSaldo;
        try {
            conta = contaClient.contaPorNumero(evento.getNumeroConta()).getBody();
            contaSaldo = contaClient.saldoConta(evento.getNumeroConta()).getBody();
        } catch (Exception e) {
            return JudMapper.map(evento, BigDecimal.ZERO, "RECUSADA", e.getMessage());
        }

        BigDecimal saldo = contaSaldo.getSaldo();
        BigDecimal valorSolicitadoBloqueio = evento.getValorBloqueado();

//        if (saldo.compareTo(valorSolicitadoBloqueio) > 0) {
//            conta.bloquearSaldo(valorSolicitadoBloqueio);
//            contaService.atualizarSaldo(conta);
//            return JudMapper.map(evento, conta.getSaldoBloqueado(), "CONFIRMADA", "BLOQUEIO_TOTAL");
//        } else if (saldo.compareTo(BigDecimal.ZERO) > 0) {
//            conta.bloquearSaldo(conta.getSaldo());
//            contaService.atualizarSaldo(conta);
//            return JudMapper.map(evento, conta.getSaldoBloqueado(), "CONFIRMADA", "BLOQUEIO_PARCIAL");
//        } else {
//            return JudMapper.map(evento, conta.getSaldoBloqueado(), "RECUSADA", "SALDO_ZERADO");
//        }

        return null;
    }
}