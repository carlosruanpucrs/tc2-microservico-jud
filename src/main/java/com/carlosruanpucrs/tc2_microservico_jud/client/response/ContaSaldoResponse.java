package com.carlosruanpucrs.tc2_microservico_jud.client.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContaSaldoResponse {

    BigDecimal saldo;
    BigDecimal saldoBloqueado;
}