package com.carlosruanpucrs.tc2_microservico_jud.message.event;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JudBloqueioConfirmacaoEvent {

    String idBloqueio;
    String numeroDocumentoCliente;
    Integer numeroConta;
    BigDecimal valorBloqueado;
    LocalDate dataExecucao;
    String status;
    String mensagem;
}
