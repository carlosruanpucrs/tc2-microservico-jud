package com.carlosruanpucrs.tc2_microservico_jud.client.response;

import com.carlosruanpucrs.tc2_microservico_jud.enums.SituacaoContaEnum;
import com.carlosruanpucrs.tc2_microservico_jud.enums.TipoContaEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContaResponse {

    Integer numeroConta;
    Integer numeroBeneficio;
    String documentoCliente;
    String nomeCliente;
    SituacaoContaEnum situacao;
    TipoContaEnum tipoConta;
}