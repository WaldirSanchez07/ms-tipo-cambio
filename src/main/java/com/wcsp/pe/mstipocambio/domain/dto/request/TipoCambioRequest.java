package com.wcsp.pe.mstipocambio.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoCambioRequest {

  @NotNull(message = "{tipoCambio.monto.notBlank}")
  private Double monto;
  @NotBlank(message = "{tipoCambio.monedaOrigen.notBlank}")
  private String monedaOrigen;
  @NotBlank(message = "{tipoCambio.monedaDestino.notBlank}")
  private String monedaDestino;

}
