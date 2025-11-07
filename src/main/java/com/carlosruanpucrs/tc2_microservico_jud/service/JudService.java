package com.carlosruanpucrs.tc2_microservico_jud.service;


import com.carlosruanpucrs.tc2_microservico_jud.client.ContaClient;
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
        ContaSaldoResponse contaSaldo;
        try {
            contaSaldo = contaClient.saldoConta(evento.getNumeroConta()).getBody();
        } catch (Exception e) {
            return JudMapper.map(evento, BigDecimal.ZERO, "RECUSADA", e.getMessage());
        }

        BigDecimal saldo = contaSaldo.getSaldo();
        BigDecimal valorSolicitadoBloqueio = evento.getValorBloqueado();

        if (saldo.compareTo(valorSolicitadoBloqueio) > 0) {
            contaClient.bloquearSaldo(evento.getNumeroConta(), valorSolicitadoBloqueio);
            return JudMapper.map(evento, valorSolicitadoBloqueio, "CONFIRMADA", "BLOQUEIO_TOTAL");
        } else if (saldo.compareTo(BigDecimal.ZERO) > 0) {
            contaClient.bloquearSaldo(evento.getNumeroConta(), saldo);
            return JudMapper.map(evento, saldo, "CONFIRMADA", "BLOQUEIO_PARCIAL");
        } else {
            return JudMapper.map(evento, saldo, "RECUSADA", "SALDO_ZERADO");
        }
    }
}