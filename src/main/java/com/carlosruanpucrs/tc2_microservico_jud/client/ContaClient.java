package com.carlosruanpucrs.tc2_microservico_jud.client;

import com.carlosruanpucrs.tc2_microservico_jud.client.response.ContaResponse;
import com.carlosruanpucrs.tc2_microservico_jud.client.response.ContaSaldoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "conta-service", path = "/v1/contas")
public interface ContaClient {

    @GetMapping("/{numeroConta}")
    ResponseEntity<ContaResponse> contaPorNumero(@PathVariable Integer numeroConta);

    @GetMapping("/{numeroConta}/saldo")
    ResponseEntity<ContaSaldoResponse> saldoConta(@PathVariable Integer numeroConta);
}
