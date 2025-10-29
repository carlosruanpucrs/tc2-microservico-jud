package com.carlosruanpucrs.tc2_microservico_jud.mapper;

import com.carlosruanpucrs.tc2_microservico_jud.message.event.JudBloqueioConfirmacaoEvent;
import com.carlosruanpucrs.tc2_microservico_jud.message.event.JudBloqueioEvent;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class JudMapper {

    public static JudBloqueioConfirmacaoEvent map(JudBloqueioEvent evento, BigDecimal valorBloqueado, String status, String mensagem) {
        return JudBloqueioConfirmacaoEvent.builder()
                .idBloqueio(evento.getIdBloqueio())
                .numeroDocumentoCliente(evento.getNumeroDocumentoCliente())
                .numeroConta(evento.getNumeroConta())
                .dataExecucao(LocalDate.now())
                .status(status)
                .mensagem(mensagem)
                .valorBloqueado(Objects.equals("CONFIRMADA", status) ? valorBloqueado : BigDecimal.ZERO)
                .build();
    }
}
