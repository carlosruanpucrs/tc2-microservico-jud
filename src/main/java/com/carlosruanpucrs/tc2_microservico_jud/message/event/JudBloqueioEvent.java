package com.carlosruanpucrs.tc2_microservico_jud.message.event;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JudBloqueioEvent implements Serializable {

    String idBloqueio;
    String numeroDocumentoCliente;
    Integer numeroConta;
    BigDecimal valorBloqueado;
    LocalDate dataEmissao;
}