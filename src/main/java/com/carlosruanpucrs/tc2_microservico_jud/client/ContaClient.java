package com.carlosruanpucrs.tc2_microservico_jud.client;

import com.carlosruanpucrs.tc2_microservico_jud.client.response.ContaSaldoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Component
@FeignClient(name = "conta-service", path = "/v1/contas")
public interface ContaClient {

    @PostMapping("/{numeroConta}/bloqueio-saldo")
    ResponseEntity<Void> bloquearSaldo(@PathVariable Integer numeroConta, @RequestParam BigDecimal valor);

    @GetMapping("/{numeroConta}/saldo")
    ResponseEntity<ContaSaldoResponse> saldoConta(@PathVariable Integer numeroConta);
}
